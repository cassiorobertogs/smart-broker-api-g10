package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.*

@Entity
data class ProfessorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    val idProfessor: Long? = null,

    @Column(nullable = false)
    val nome: String,

    @Column(nullable = false)
    val especialidade: String
)
