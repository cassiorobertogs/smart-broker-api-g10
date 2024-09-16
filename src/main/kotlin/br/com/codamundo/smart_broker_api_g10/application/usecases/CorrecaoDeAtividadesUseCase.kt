package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.application.ports.input.CorrecaoDeAtividadesInput
import br.com.codamundo.smart_broker_api_g10.application.ports.output.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.application.ports.output.GptOutput
import br.com.codamundo.smart_broker_api_g10.domain.models.AgenteModel
import br.com.codamundo.smart_broker_api_g10.domain.exceptions.NotFoundException
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.RespostaEntity
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.RespostaBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.CorrecaoResponse
import br.com.codamundo.smart_broker_api_g10.domain.services.AgenteBuilder
import java.time.LocalDateTime

class CorrecaoDeAtividadesUseCase(
    private val gptOutput: GptOutput,  // Agora dependemos da interface
    private val databaseOutput: DatabaseOutput,  // Dependemos da abstração
    private val agenteBuilder: AgenteBuilder
) : CorrecaoDeAtividadesInput {

    override fun corrigirAtividade(
        atividadeId: Long,
        alunoId: Long,
        respostaDoAluno: RespostaBodyDto
    ): CorrecaoResponse {
        // Recuperar a atividade
        val atividade = databaseOutput.findAtividadeById(atividadeId)
            ?: throw NotFoundException("Atividade não encontrada com id $atividadeId")

        // Recuperar o aluno
        val aluno = databaseOutput.findAlunoById(alunoId)
            ?: throw NotFoundException("Aluno não encontrado com id $alunoId")

        // Recuperar o contexto padrão
        val contexto = databaseOutput.findContextoPadrao()
            ?: throw NotFoundException("Contexto não encontrado")

        // Construir o modelo do agente (contexto + dados da atividade e aluno)
        val agenteModel = AgenteModel(
            aluno = aluno,
            atividade = atividade,
            contexto = contexto,
            respostaDoAluno = respostaDoAluno.respostaAluno
        )

        // Montar o prompt do agente
        val prompt = agenteBuilder.montarAgente(agenteModel)

        // Enviar o prompt para o GPT e obter a resposta
        val respostaGpt = gptOutput.postEnriquecerCorrecao(prompt)

        // Calcular o coeficiente de acertividade
        val coeficienteAcertividade = calcularCoeficienteAcertividade(respostaGpt)

        // Criar a entidade de resposta
        val respostaEntity = RespostaEntity(
            aluno = aluno,
            atividade = atividade,
            respostaAluno = respostaDoAluno.respostaAluno,
            respostaCorrecao = respostaGpt,
            coeficienteAcertividade = coeficienteAcertividade,
            dataHoraResposta = LocalDateTime.now()
        )

        // Salvar a resposta no banco de dados
        databaseOutput.saveResposta(respostaEntity)

        // Retornar a resposta finalizada para o controller
        return CorrecaoResponse.fromEntity(respostaEntity)
    }

    private fun calcularCoeficienteAcertividade(respostaGpt: String): Double {
        // Lógica de cálculo real (exemplo básico)
        return 1.0 // Lógica placeholder
    }

    // Função para recuperar todas as respostas de um aluno específico
    override fun findRespostasByAlunoId(alunoId: Long): List<CorrecaoResponse> {
        val respostas = databaseOutput.findRespostasByAlunoId(alunoId)
        return respostas.map { CorrecaoResponse.fromEntity(it) }
    }

    // Função para deletar todas as respostas associadas a uma atividade específica
    override fun deleteRespostasByAtividadeId(atividadeId: Long) {
        databaseOutput.deleteRespostasByAtividadeId(atividadeId)
    }
}
