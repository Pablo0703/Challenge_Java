package br.com.fiap.ChallengeMottu.Controller;

import br.com.fiap.ChallengeMottu.Dto.MotociclistaDTO;
import br.com.fiap.ChallengeMottu.Service.MotociclistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motociclistas")
public class MotociclistaController {

    @Autowired
    private MotociclistaService service;

    @PostMapping
    public ResponseEntity<MotociclistaDTO> salvar(@Valid @RequestBody MotociclistaDTO dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotociclistaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<MotociclistaDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotociclistaDTO> atualizar(@PathVariable Long id, @Valid @RequestBody MotociclistaDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
