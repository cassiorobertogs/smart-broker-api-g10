package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.*

@Entity
data class ProfessorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    val idProfessor: Long? = null,

    @Column
    val nome: String? = null,

    @Column
    val especialidade: String? = null
)
