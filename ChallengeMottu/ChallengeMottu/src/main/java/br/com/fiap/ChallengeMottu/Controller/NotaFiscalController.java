package br.com.fiap.ChallengeMottu.Controller;

import br.com.fiap.ChallengeMottu.Dto.NotaFiscalDTO;
import br.com.fiap.ChallengeMottu.Service.NotaFiscalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas-fiscais")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService service;

    @PostMapping
    public ResponseEntity<NotaFiscalDTO> salvar(@Valid @RequestBody NotaFiscalDTO dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaFiscalDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<NotaFiscalDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaFiscalDTO> atualizar(@PathVariable Long id, @Valid @RequestBody NotaFiscalDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
