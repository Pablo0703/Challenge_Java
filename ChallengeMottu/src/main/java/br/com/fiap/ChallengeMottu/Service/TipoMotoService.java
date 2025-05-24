package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.TipoMotoDTO;
import br.com.fiap.ChallengeMottu.Entity.TipoMotoEntity;
import br.com.fiap.ChallengeMottu.Repository.TipoMotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoMotoService {

    @Autowired
    private TipoMotoRepository repository;

    private TipoMotoEntity toEntity(TipoMotoDTO dto) {
        TipoMotoEntity entity = new TipoMotoEntity();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        entity.setCategoria(dto.getCategoria());
        return entity;
    }

    private TipoMotoDTO toDTO(TipoMotoEntity entity) {
        TipoMotoDTO dto = new TipoMotoDTO();
        dto.setId(entity.getId());
        dto.setDescricao(entity.getDescricao());
        dto.setCategoria(entity.getCategoria());
        return dto;
    }

    public TipoMotoDTO salvar(TipoMotoDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public TipoMotoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de moto não encontrado"));
    }

    public List<TipoMotoDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public TipoMotoDTO atualizar(Long id, TipoMotoDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de moto não encontrado");
        }
        dto.setId(id);
        return toDTO(repository.save(toEntity(dto)));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de moto não encontrado");
        }
        repository.deleteById(id);
    }
}
