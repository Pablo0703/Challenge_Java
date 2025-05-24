package br.com.fiap.ChallengeMottu.Controller;

import br.com.fiap.ChallengeMottu.Dto.PatioDTO;
import br.com.fiap.ChallengeMottu.Service.PatioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patios")
public class PatioController {

    @Autowired
    private PatioService patioService;

    @PostMapping
    public ResponseEntity<PatioDTO> salvar(@Valid @RequestBody PatioDTO dto) {
        return ResponseEntity.status(201).body(patioService.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatioDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(patioService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PatioDTO>> listarTodos() {
        return ResponseEntity.ok(patioService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatioDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PatioDTO dto) {
        return ResponseEntity.ok(patioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        patioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
