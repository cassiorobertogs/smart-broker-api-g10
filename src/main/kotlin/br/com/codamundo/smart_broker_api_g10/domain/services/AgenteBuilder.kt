package br.com.codamundo.smart_broker_api_g10.domain.services

import br.com.codamundo.smart_broker_api_g10.domain.models.AgenteModel

class AgenteBuilder {

    fun montarAgente(agenteModel: AgenteModel): String {
        val prompt = """
            ${agenteModel.contexto.prompt}
            
            **Dados do Aluno:**
            Nome: ${agenteModel.aluno.nome}
            Idade: ${agenteModel.aluno.idade}
            Estilo de Aprendizagem: ${agenteModel.aluno.estiloAprendizagem}
            Interesses e Hobbies: ${agenteModel.aluno.interessesHobbies}
            Passa Tempo Preferido: ${agenteModel.aluno.passaTempoPreferido}
            Filme/Série Preferido: ${agenteModel.aluno.filmeSeriePreferido}
            Artista Favorito: ${agenteModel.aluno.artista}
            Pessoa com Deficiência: ${if (agenteModel.aluno.pessoaComDeficiencia == true) "Sim, tipo: ${agenteModel.aluno.pessoaComDeficiencia}" else "Não"}
            
            **Dados da Atividade:**
            Enunciado: ${agenteModel.atividade.enunciado}
            Resposta Esperada: ${agenteModel.atividade.respostaEsperada}
            Área de Conhecimento: ${agenteModel.atividade.areaConhecimento}
            Nível de Dificuldade: ${agenteModel.atividade.nivelDificuldade}
            Objetivos de Aprendizagem: ${agenteModel.atividade.objetivosAprendizagem}
            
            **Resposta do Aluno:**
            ${agenteModel.respostaDoAluno}
            
            Por favor, forneça um feedback detalhado e personalizado para o aluno, considerando suas características pessoais e a atividade realizada.
        """.trimIndent()
        return prompt
    }
}
