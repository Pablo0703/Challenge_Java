package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.NotaFiscalDTO;
import br.com.fiap.ChallengeMottu.Entity.NotaFiscalEntity;
import br.com.fiap.ChallengeMottu.Repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository repository;

    private NotaFiscalEntity toEntity(NotaFiscalDTO dto) {
        NotaFiscalEntity entity = new NotaFiscalEntity();
        entity.setId(dto.getId());
        entity.setNumero(dto.getNumero());
        entity.setSerie(dto.getSerie());
        entity.setModelo(dto.getModelo());
        entity.setChaveAcesso(dto.getChaveAcesso());
        entity.setDataEmissao(dto.getDataEmissao());
        entity.setValorTotal(dto.getValorTotal());
        entity.setFornecedor(dto.getFornecedor());
        entity.setCnpjFornecedor(dto.getCnpjFornecedor());
        return entity;
    }

    private NotaFiscalDTO toDTO(NotaFiscalEntity entity) {
        NotaFiscalDTO dto = new NotaFiscalDTO();
        dto.setId(entity.getId());
        dto.setNumero(entity.getNumero());
        dto.setSerie(entity.getSerie());
        dto.setModelo(entity.getModelo());
        dto.setChaveAcesso(entity.getChaveAcesso());
        dto.setDataEmissao(entity.getDataEmissao());
        dto.setValorTotal(entity.getValorTotal());
        dto.setFornecedor(entity.getFornecedor());
        dto.setCnpjFornecedor(entity.getCnpjFornecedor());
        return dto;
    }

    public NotaFiscalDTO salvar(NotaFiscalDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public NotaFiscalDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota Fiscal não encontrada"));
    }

    public List<NotaFiscalDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public NotaFiscalDTO atualizar(Long id, NotaFiscalDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota Fiscal não encontrada");
        }
        dto.setId(id);
        return toDTO(repository.save(toEntity(dto)));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota Fiscal não encontrada");
        }
        repository.deleteById(id);
    }
}