package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.PatioDTO;
import br.com.fiap.ChallengeMottu.Entity.FilialEntity;
import br.com.fiap.ChallengeMottu.Entity.PatioEntity;
import br.com.fiap.ChallengeMottu.Repository.FilialRepository;
import br.com.fiap.ChallengeMottu.Repository.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatioService {

    @Autowired
    private PatioRepository patioRepository;

    @Autowired
    private FilialRepository filialRepository;

    private PatioEntity toEntity(PatioDTO dto) {
        FilialEntity filial = filialRepository.findById(dto.getIdFilial())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filial não encontrada"));

        PatioEntity entity = new PatioEntity();
        entity.setId(dto.getId());
        entity.setFilial(filial);
        entity.setNome(dto.getNome());
        entity.setAreaM2(dto.getAreaM2());
        entity.setCapacidade(dto.getCapacidade());
        entity.setAtivo(dto.getAtivo());
        return entity;
    }

    private PatioDTO toDTO(PatioEntity entity) {
        PatioDTO dto = new PatioDTO();
        dto.setId(entity.getId());
        dto.setIdFilial(entity.getFilial().getId());
        dto.setNome(entity.getNome());
        dto.setAreaM2(entity.getAreaM2());
        dto.setCapacidade(entity.getCapacidade());
        dto.setAtivo(entity.getAtivo());
        return dto;
    }

    public PatioDTO salvar(PatioDTO dto) {
        return toDTO(patioRepository.save(toEntity(dto)));
    }

    public PatioDTO buscarPorId(Long id) {
        return patioRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pátio não encontrado"));
    }

    public List<PatioDTO> listarTodos() {
        return patioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PatioDTO atualizar(Long id, PatioDTO dto) {
        if (!patioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pátio não encontrado");
        }
        dto.setId(id);
        return toDTO(patioRepository.save(toEntity(dto)));
    }

    public void deletar(Long id) {
        if (!patioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pátio não encontrado");
        }
        patioRepository.deleteById(id);
    }
}
