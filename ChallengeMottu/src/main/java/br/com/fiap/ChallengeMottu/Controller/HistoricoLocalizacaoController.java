package br.com.fiap.ChallengeMottu.Controller;

import br.com.fiap.ChallengeMottu.Dto.HistoricoLocalizacaoDTO;
import br.com.fiap.ChallengeMottu.Service.HistoricoLocalizacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historicos-localizacao")
public class HistoricoLocalizacaoController {

    @Autowired
    private HistoricoLocalizacaoService service;

    @PostMapping
    public ResponseEntity<HistoricoLocalizacaoDTO> salvar(@Valid @RequestBody HistoricoLocalizacaoDTO dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoLocalizacaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<HistoricoLocalizacaoDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricoLocalizacaoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody HistoricoLocalizacaoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
