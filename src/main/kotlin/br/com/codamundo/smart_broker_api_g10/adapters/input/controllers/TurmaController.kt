import br.com.codamundo.smart_broker_api_g10.application.ports.input.TurmaInput
import br.com.codamundo.smart_broker_api_g10.application.usecases.TurmaUseCase
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.TurmaRequest
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.TurmaResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/turmas")
class TurmaController(private val turmaInput: TurmaInput) {

    @GetMapping("/{id}")
    fun getTurma(@PathVariable id: Long): ResponseEntity<TurmaResponse> {
        val turmaResponse = turmaUseCase.getTurma(id)
        return ResponseEntity.ok(turmaResponse)
    }

    @PostMapping
    fun createTurma(@RequestBody turmaRequest: TurmaRequest): ResponseEntity<TurmaResponse> {
        val turmaResponse = turmaInput.createTurma(turmaRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaResponse)
    }

    @PutMapping("/{id}")
    fun updateTurma(@PathVariable id: Long, @RequestBody turmaRequest: TurmaRequest): ResponseEntity<Void> {
        turmaUseCase.updateTurma(id, turmaRequest)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    fun deleteTurma(@PathVariable id: Long): ResponseEntity<Void> {
        turmaUseCase.deleteTurma(id)
        return ResponseEntity.noContent().build()
    }
}
