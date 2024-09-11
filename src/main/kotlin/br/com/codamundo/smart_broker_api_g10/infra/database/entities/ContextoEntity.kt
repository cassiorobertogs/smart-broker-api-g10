package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.*

@Entity
data class ContextoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contexto")
    val idContexto: Long? = null,

    @Column(nullable = false)
    val prompt: String,

    @Column(name = "coeficiente_didatico", nullable = false)
    val coeficienteDidatico: Double
)
