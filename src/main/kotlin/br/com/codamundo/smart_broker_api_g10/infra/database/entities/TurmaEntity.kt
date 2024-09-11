package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.*

@Entity
data class TurmaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    val idTurma: Long? = null,

    @ManyToOne
    @JoinColumn(name = "id_oficina", nullable = false)
    val oficina: OficinaEntity,  // Relacionamento com a tabela Oficina

    @Column(name = "quantidade_alunos", nullable = false)
    val quantidadeAlunos: Int
)
