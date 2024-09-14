package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Column

@Entity
data class AlunoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    val alunoId: Long? = null,

    @Column(nullable = false)
    val nome: String,

    @Column(nullable = false)
    val idade: Int,

    @Column(name = "oficina_cadastrada", nullable = false)
    val oficinaCadastrada: String,

    @Column(nullable = false)
    val turma: String,

    @Column(name = "pessoa_com_deficiencia", nullable = true)
    val pessoaComDeficiencia: Boolean?,

    @Column(name = "tipod_de_deficiencia", nullable = true)
    val tipodDeficiencia: String?,

    @Column(name = "estilo_aprendizagem")
    val estiloAprendizagem: String,

    @Column(name = "interesses_hobbies")
    val interessesHobbies: String,

    @Column(name = "passa_tempo_preferido")
    val passaTempoPreferido: String,

    @Column(name = "filme_serie_preferido")
    val filmeSeriePreferido: String,

    @Column(nullable = false)
    val artista: String
)
