package br.com.fiap.ChallengeMottu.Controller;

import br.com.fiap.ChallengeMottu.Dto.LocalizacaoMotoDTO;
import br.com.fiap.ChallengeMottu.Service.LocalizacaoMotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacoes-moto")
public class LocalizacaoMotoController {

    @Autowired
    private LocalizacaoMotoService service;

    @PostMapping
    public ResponseEntity<LocalizacaoMotoDTO> salvar(@Valid @RequestBody LocalizacaoMotoDTO dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalizacaoMotoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<LocalizacaoMotoDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalizacaoMotoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody LocalizacaoMotoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
