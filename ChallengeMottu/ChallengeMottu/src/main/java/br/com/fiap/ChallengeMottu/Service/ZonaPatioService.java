package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.ZonaPatioDTO;
import br.com.fiap.ChallengeMottu.Entity.PatioEntity;
import br.com.fiap.ChallengeMottu.Entity.ZonaPatioEntity;
import br.com.fiap.ChallengeMottu.Repository.PatioRepository;
import br.com.fiap.ChallengeMottu.Repository.ZonaPatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZonaPatioService {

    @Autowired
    private ZonaPatioRepository zonaPatioRepository;

    @Autowired
    private PatioRepository patioRepository;

    private ZonaPatioEntity toEntity(ZonaPatioDTO dto) {
        PatioEntity patio = patioRepository.findById(dto.getIdPatio())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pátio não encontrado"));

        ZonaPatioEntity entity = new ZonaPatioEntity();
        entity.setId(dto.getId());
        entity.setPatio(patio);
        entity.setNomeZona(dto.getNomeZona());
        entity.setTipoZona(dto.getTipoZona());
        entity.setCapacidade(dto.getCapacidade());
        return entity;
    }

    private ZonaPatioDTO toDTO(ZonaPatioEntity entity) {
        ZonaPatioDTO dto = new ZonaPatioDTO();
        dto.setId(entity.getId());
        dto.setIdPatio(entity.getPatio().getId());
        dto.setNomeZona(entity.getNomeZona());
        dto.setTipoZona(entity.getTipoZona());
        dto.setCapacidade(entity.getCapacidade());
        return dto;
    }

    public ZonaPatioDTO salvar(ZonaPatioDTO dto) {
        return toDTO(zonaPatioRepository.save(toEntity(dto)));
    }

    public ZonaPatioDTO buscarPorId(Long id) {
        return zonaPatioRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zona de pátio não encontrada"));
    }

    public List<ZonaPatioDTO> listarTodos() {
        return zonaPatioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ZonaPatioDTO atualizar(Long id, ZonaPatioDTO dto) {
        if (!zonaPatioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Zona de pátio não encontrada");
        }
        dto.setId(id);
        return toDTO(zonaPatioRepository.save(toEntity(dto)));
    }

    public void deletar(Long id) {
        if (!zonaPatioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Zona de pátio não encontrada");
        }
        zonaPatioRepository.deleteById(id);
    }
}
