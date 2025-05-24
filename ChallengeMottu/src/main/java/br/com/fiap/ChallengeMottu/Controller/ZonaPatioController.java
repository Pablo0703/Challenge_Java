package br.com.fiap.ChallengeMottu.Controller;

import br.com.fiap.ChallengeMottu.Dto.ZonaPatioDTO;
import br.com.fiap.ChallengeMottu.Service.ZonaPatioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zonas-patio")
public class ZonaPatioController {

    @Autowired
    private ZonaPatioService zonaPatioService;

    @PostMapping
    public ResponseEntity<ZonaPatioDTO> salvar(@Valid @RequestBody ZonaPatioDTO dto) {
        return ResponseEntity.status(201).body(zonaPatioService.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZonaPatioDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(zonaPatioService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ZonaPatioDTO>> listarTodos() {
        return ResponseEntity.ok(zonaPatioService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ZonaPatioDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ZonaPatioDTO dto) {
        return ResponseEntity.ok(zonaPatioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        zonaPatioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
