package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.*

@Entity
data class OficinaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oficina_id")
    val oficinaId: Long? = null,

    @Column(nullable = false)
    val escola: String
)
