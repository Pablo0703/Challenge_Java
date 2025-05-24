package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.LocalizacaoMotoDTO;
import br.com.fiap.ChallengeMottu.Entity.LocalizacaoMotoEntity;
import br.com.fiap.ChallengeMottu.Entity.MotoEntity;
import br.com.fiap.ChallengeMottu.Entity.ZonaPatioEntity;
import br.com.fiap.ChallengeMottu.Repository.LocalizacaoMotoRepository;
import br.com.fiap.ChallengeMottu.Repository.MotoRepository;
import br.com.fiap.ChallengeMottu.Repository.ZonaPatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalizacaoMotoService {

    @Autowired private LocalizacaoMotoRepository repository;
    @Autowired private MotoRepository motoRepository;
    @Autowired private ZonaPatioRepository zonaPatioRepository;

    private LocalizacaoMotoEntity toEntity(LocalizacaoMotoDTO dto) {
        LocalizacaoMotoEntity entity = new LocalizacaoMotoEntity();
        entity.setId(dto.getId());

        MotoEntity moto = motoRepository.findById(dto.getIdMoto())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada"));
        entity.setMoto(moto);

        ZonaPatioEntity zona = zonaPatioRepository.findById(dto.getIdZona())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zona não encontrada"));
        entity.setZonaPatio(zona);

        entity.setDataHoraEntrada(dto.getDataHoraEntrada());
        entity.setDataHoraSaida(dto.getDataHoraSaida());
        return entity;
    }

    private LocalizacaoMotoDTO toDTO(LocalizacaoMotoEntity entity) {
        LocalizacaoMotoDTO dto = new LocalizacaoMotoDTO();
        dto.setId(entity.getId());
        dto.setIdMoto(entity.getMoto().getId());
        dto.setIdZona(entity.getZonaPatio().getId());
        dto.setDataHoraEntrada(entity.getDataHoraEntrada());
        dto.setDataHoraSaida(entity.getDataHoraSaida());
        return dto;
    }

    public LocalizacaoMotoDTO salvar(LocalizacaoMotoDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public LocalizacaoMotoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Localização não encontrada"));
    }

    public List<LocalizacaoMotoDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public LocalizacaoMotoDTO atualizar(Long id, LocalizacaoMotoDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Localização não encontrada");
        }
        dto.setId(id);
        return toDTO(repository.save(toEntity(dto)));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Localização não encontrada");
        }
        repository.deleteById(id);
    }
}
