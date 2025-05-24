package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.HistoricoLocalizacaoDTO;
import br.com.fiap.ChallengeMottu.Entity.*;
import br.com.fiap.ChallengeMottu.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricoLocalizacaoService {

    @Autowired private HistoricoLocalizacaoRepository historicoRepository;
    @Autowired private MotoRepository motoRepository;
    @Autowired private MotociclistaRepository motociclistaRepository;
    @Autowired private ZonaPatioRepository zonaPatioRepository;
    @Autowired private StatusOperacaoRepository statusOperacaoRepository;

    private HistoricoLocalizacaoEntity toEntity(HistoricoLocalizacaoDTO dto) {
        HistoricoLocalizacaoEntity entity = new HistoricoLocalizacaoEntity();

        entity.setId(dto.getId());

        entity.setMoto(motoRepository.findById(dto.getIdMoto())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada")));

        if (dto.getIdMotociclista() != null) {
            entity.setMotociclista(motociclistaRepository.findById(dto.getIdMotociclista())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motociclista não encontrado")));
        }

        if (dto.getIdZonaPatio() != null) {
            entity.setZonaPatio(zonaPatioRepository.findById(dto.getIdZonaPatio())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zona de pátio não encontrada")));
        }

        if (dto.getIdStatusOperacao() != null) {
            entity.setStatusOperacao(statusOperacaoRepository.findById(dto.getIdStatusOperacao())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status de operação não encontrado")));
        }

        entity.setDataHoraSaida(dto.getDataHoraSaida());
        entity.setDataHoraEntrada(dto.getDataHoraEntrada());
        entity.setKmRodados(dto.getKmRodados());

        return entity;
    }

    private HistoricoLocalizacaoDTO toDTO(HistoricoLocalizacaoEntity entity) {
        HistoricoLocalizacaoDTO dto = new HistoricoLocalizacaoDTO();

        dto.setId(entity.getId());
        dto.setIdMoto(entity.getMoto().getId());
        dto.setIdMotociclista(entity.getMotociclista() != null ? entity.getMotociclista().getId() : null);
        dto.setIdZonaPatio(entity.getZonaPatio() != null ? entity.getZonaPatio().getId() : null);
        dto.setIdStatusOperacao(entity.getStatusOperacao() != null ? entity.getStatusOperacao().getId() : null);
        dto.setDataHoraSaida(entity.getDataHoraSaida());
        dto.setDataHoraEntrada(entity.getDataHoraEntrada());
        dto.setKmRodados(entity.getKmRodados());

        return dto;
    }

    public HistoricoLocalizacaoDTO salvar(HistoricoLocalizacaoDTO dto) {
        return toDTO(historicoRepository.save(toEntity(dto)));
    }

    public HistoricoLocalizacaoDTO buscarPorId(Long id) {
        return historicoRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico não encontrado"));
    }

    public List<HistoricoLocalizacaoDTO> listarTodos() {
        return historicoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public HistoricoLocalizacaoDTO atualizar(Long id, HistoricoLocalizacaoDTO dto) {
        if (!historicoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico não encontrado");
        }
        dto.setId(id);
        return toDTO(historicoRepository.save(toEntity(dto)));
    }

    public void deletar(Long id) {
        if (!historicoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico não encontrado");
        }
        historicoRepository.deleteById(id);
    }
}
