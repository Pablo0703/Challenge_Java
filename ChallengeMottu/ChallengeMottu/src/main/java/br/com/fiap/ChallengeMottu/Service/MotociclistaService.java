package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.MotociclistaDTO;
import br.com.fiap.ChallengeMottu.Entity.EnderecoEntity;
import br.com.fiap.ChallengeMottu.Entity.MotociclistaEntity;
import br.com.fiap.ChallengeMottu.Repository.EnderecoRepository;
import br.com.fiap.ChallengeMottu.Repository.MotociclistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotociclistaService {

    @Autowired
    private MotociclistaRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    private MotociclistaEntity toEntity(MotociclistaDTO dto) {
        MotociclistaEntity entity = new MotociclistaEntity();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setCnh(dto.getCnh());
        entity.setDataValidadeCnh(dto.getDataValidadeCnh());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());
        entity.setDataCadastro(dto.getDataCadastro());
        entity.setAtivo(dto.getAtivo());

        if (dto.getIdEndereco() != null) {
            EnderecoEntity endereco = enderecoRepository.findById(dto.getIdEndereco())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado"));
            entity.setEndereco(endereco);
        }

        return entity;
    }

    private MotociclistaDTO toDTO(MotociclistaEntity entity) {
        MotociclistaDTO dto = new MotociclistaDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setCnh(entity.getCnh());
        dto.setDataValidadeCnh(entity.getDataValidadeCnh());
        dto.setTelefone(entity.getTelefone());
        dto.setEmail(entity.getEmail());
        dto.setDataCadastro(entity.getDataCadastro());
        dto.setAtivo(entity.getAtivo());
        dto.setIdEndereco(entity.getEndereco() != null ? entity.getEndereco().getId() : null);
        return dto;
    }

    public MotociclistaDTO salvar(MotociclistaDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public MotociclistaDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motociclista não encontrado"));
    }

    public List<MotociclistaDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public MotociclistaDTO atualizar(Long id, MotociclistaDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Motociclista não encontrado");
        }
        dto.setId(id);
        return toDTO(repository.save(toEntity(dto)));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Motociclista não encontrado");
        }
        repository.deleteById(id);
    }
}
