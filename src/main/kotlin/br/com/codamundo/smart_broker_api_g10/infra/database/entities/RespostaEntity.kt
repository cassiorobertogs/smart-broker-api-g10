package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class RespostaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resposta")
    val idResposta: Long? = null,

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    val aluno: AlunoEntity,  // Relacionamento com a tabela Aluno

    @Column(name = "resposta_aluno", nullable = false)
    val respostaAluno: String,

    @Column(name = "coeficiente_acertividade", nullable = false)
    val coeficienteAcertividade: Double,

    @Column(name = "data_hora_resposta", nullable = false, updatable = false)
    val dataHoraResposta: LocalDateTime? = null
) {
    @PrePersist
    fun prePersist() {
        if (dataHoraResposta == null) {
            (this as RespostaEntity).dataHoraResposta = LocalDateTime.now()
        }
    }
}
