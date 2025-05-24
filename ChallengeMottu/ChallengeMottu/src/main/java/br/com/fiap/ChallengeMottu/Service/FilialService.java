package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.FilialDTO;
import br.com.fiap.ChallengeMottu.Entity.EnderecoEntity;
import br.com.fiap.ChallengeMottu.Entity.FilialEntity;
import br.com.fiap.ChallengeMottu.Repository.EnderecoRepository;
import br.com.fiap.ChallengeMottu.Repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilialService {

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    private FilialEntity toEntity(FilialDTO dto) {
        EnderecoEntity endereco = enderecoRepository.findById(dto.getIdEndereco())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado"));

        FilialEntity entity = new FilialEntity();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setCnpj(dto.getCnpj());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());
        entity.setAtivo(dto.getAtivo());
        entity.setEndereco(endereco);
        return entity;
    }

    private FilialDTO toDTO(FilialEntity entity) {
        FilialDTO dto = new FilialDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCnpj(entity.getCnpj());
        dto.setTelefone(entity.getTelefone());
        dto.setEmail(entity.getEmail());
        dto.setAtivo(entity.getAtivo());
        dto.setIdEndereco(entity.getEndereco().getId());
        return dto;
    }

    public FilialDTO salvar(FilialDTO dto) {
        try {
            return toDTO(filialRepository.save(toEntity(dto)));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao salvar filial", e);
        }
    }

    public FilialDTO buscarPorId(Long id) {
        return filialRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filial não encontrada"));
    }

    public List<FilialDTO> listarTodos() {
        return filialRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public FilialDTO atualizar(Long id, FilialDTO dto) {
        FilialEntity existente = filialRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filial não encontrada"));

        EnderecoEntity endereco = enderecoRepository.findById(dto.getIdEndereco())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado"));

        existente.setNome(dto.getNome());
        existente.setCnpj(dto.getCnpj());
        existente.setTelefone(dto.getTelefone());
        existente.setEmail(dto.getEmail());
        existente.setAtivo(dto.getAtivo());
        existente.setEndereco(endereco);

        return toDTO(filialRepository.save(existente));
    }

    public void deletar(Long id) {
        if (!filialRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filial não encontrada");
        }
        filialRepository.deleteById(id);
    }
}
