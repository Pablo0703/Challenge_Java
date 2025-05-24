package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.EnderecoDTO;
import br.com.fiap.ChallengeMottu.Entity.EnderecoEntity;
import br.com.fiap.ChallengeMottu.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    private EnderecoEntity toEntity(EnderecoDTO dto) {
        EnderecoEntity entity = new EnderecoEntity();
        entity.setId(dto.getId());
        entity.setLogradouro(dto.getLogradouro());
        entity.setNumero(dto.getNumero());
        entity.setComplemento(dto.getComplemento());
        entity.setBairro(dto.getBairro());
        entity.setCep(dto.getCep());
        entity.setCidade(dto.getCidade());
        entity.setEstado(dto.getEstado());
        entity.setPais(dto.getPais());
        return entity;
    }

    private EnderecoDTO toDTO(EnderecoEntity entity) {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setId(entity.getId());
        dto.setLogradouro(entity.getLogradouro());
        dto.setNumero(entity.getNumero());
        dto.setComplemento(entity.getComplemento());
        dto.setBairro(entity.getBairro());
        dto.setCep(entity.getCep());
        dto.setCidade(entity.getCidade());
        dto.setEstado(entity.getEstado());
        dto.setPais(entity.getPais());
        return dto;
    }

    public EnderecoDTO salvar(EnderecoDTO dto) {
        try {
            return toDTO(repository.save(toEntity(dto)));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao salvar endereço", e);
        }
    }

    public EnderecoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado"));
    }

    public List<EnderecoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public EnderecoDTO atualizar(Long id, EnderecoDTO dto) {
        EnderecoEntity existente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado"));

        existente.setLogradouro(dto.getLogradouro());
        existente.setNumero(dto.getNumero());
        existente.setComplemento(dto.getComplemento());
        existente.setBairro(dto.getBairro());
        existente.setCep(dto.getCep());
        existente.setCidade(dto.getCidade());
        existente.setEstado(dto.getEstado());
        existente.setPais(dto.getPais());

        return toDTO(repository.save(existente));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        }
        repository.deleteById(id);
    }
}
