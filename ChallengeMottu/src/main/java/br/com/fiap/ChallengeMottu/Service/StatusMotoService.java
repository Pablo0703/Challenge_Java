package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.StatusMotoDTO;
import br.com.fiap.ChallengeMottu.Entity.StatusMotoEntity;
import br.com.fiap.ChallengeMottu.Repository.StatusMotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusMotoService {

    @Autowired
    private StatusMotoRepository repository;

    private StatusMotoEntity toEntity(StatusMotoDTO dto) {
        StatusMotoEntity entity = new StatusMotoEntity();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        entity.setDisponivel(dto.getDisponivel());
        return entity;
    }

    private StatusMotoDTO toDTO(StatusMotoEntity entity) {
        StatusMotoDTO dto = new StatusMotoDTO();
        dto.setId(entity.getId());
        dto.setDescricao(entity.getDescricao());
        dto.setDisponivel(entity.getDisponivel());
        return dto;
    }

    public StatusMotoDTO salvar(StatusMotoDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public StatusMotoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status da moto não encontrado"));
    }

    public List<StatusMotoDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public StatusMotoDTO atualizar(Long id, StatusMotoDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Status da moto não encontrado");
        }
        dto.setId(id);
        return toDTO(repository.save(toEntity(dto)));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Status da moto não encontrado");
        }
        repository.deleteById(id);
    }
}
