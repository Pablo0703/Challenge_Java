package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.StatusOperacaoDTO;
import br.com.fiap.ChallengeMottu.Entity.StatusOperacaoEntity;
import br.com.fiap.ChallengeMottu.Repository.StatusOperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusOperacaoService {

    @Autowired
    private StatusOperacaoRepository repository;

    private StatusOperacaoEntity toEntity(StatusOperacaoDTO dto) {
        StatusOperacaoEntity entity = new StatusOperacaoEntity();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        entity.setTipoMovimentacao(dto.getTipoMovimentacao());
        return entity;
    }

    private StatusOperacaoDTO toDTO(StatusOperacaoEntity entity) {
        StatusOperacaoDTO dto = new StatusOperacaoDTO();
        dto.setId(entity.getId());
        dto.setDescricao(entity.getDescricao());
        dto.setTipoMovimentacao(entity.getTipoMovimentacao());
        return dto;
    }

    public StatusOperacaoDTO salvar(StatusOperacaoDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public StatusOperacaoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status de operação não encontrado"));
    }

    public List<StatusOperacaoDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public StatusOperacaoDTO atualizar(Long id, StatusOperacaoDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Status de operação não encontrado");
        }
        dto.setId(id);
        return toDTO(repository.save(toEntity(dto)));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Status de operação não encontrado");
        }
        repository.deleteById(id);
    }
}
