package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.*

@Entity
data class ContextoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contexto")
    val idContexto: Long? = null,

    @Column(name = "prompt")
    val prompt: String? = null,

    @Column(name = "coeficiente_didatico")
    val coeficienteDidatico: Double? = null
)
