package br.com.fiap.ChallengeMottu.Controller;

import br.com.fiap.ChallengeMottu.Dto.MotoDTO;
import br.com.fiap.ChallengeMottu.Service.MotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @PostMapping
    public ResponseEntity<MotoDTO> salvar(@Valid @RequestBody MotoDTO dto) {
        return ResponseEntity.status(201).body(motoService.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(motoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<MotoDTO>> listarTodos() {
        return ResponseEntity.ok(motoService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody MotoDTO dto) {
        return ResponseEntity.ok(motoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        motoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
