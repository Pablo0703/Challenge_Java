package br.com.fiap.ChallengeMottu.Service;

import br.com.fiap.ChallengeMottu.Dto.MotoDTO;
import br.com.fiap.ChallengeMottu.Entity.*;
import br.com.fiap.ChallengeMottu.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private TipoMotoRepository tipoMotoRepository;

    @Autowired
    private StatusMotoRepository statusMotoRepository;

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    private MotoEntity toEntity(MotoDTO dto) {
        MotoEntity entity = new MotoEntity();

        entity.setId(dto.getId());
        entity.setPlaca(dto.getPlaca());
        entity.setModelo(dto.getModelo());
        entity.setAnoFabricacao(dto.getAnoFabricacao());
        entity.setAnoModelo(dto.getAnoModelo());
        entity.setChassi(dto.getChassi());
        entity.setCilindrada(dto.getCilindrada());
        entity.setCor(dto.getCor());
        entity.setDataAquisicao(dto.getDataAquisicao());
        entity.setValorAquisicao(dto.getValorAquisicao());

        TipoMotoEntity tipo = tipoMotoRepository.findById(dto.getIdTipo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de moto não encontrado"));
        entity.setTipo(tipo);

        StatusMotoEntity status = statusMotoRepository.findById(dto.getIdStatus())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status da moto não encontrado"));
        entity.setStatus(status);

        if (dto.getIdNotaFiscal() != null) {
            NotaFiscalEntity nf = notaFiscalRepository.findById(dto.getIdNotaFiscal())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota fiscal não encontrada"));
            entity.setNotaFiscal(nf);
        } else {
            entity.setNotaFiscal(null);
        }

        return entity;
    }

    private MotoDTO toDTO(MotoEntity entity) {
        MotoDTO dto = new MotoDTO();

        dto.setId(entity.getId());
        dto.setPlaca(entity.getPlaca());
        dto.setModelo(entity.getModelo());
        dto.setAnoFabricacao(entity.getAnoFabricacao());
        dto.setAnoModelo(entity.getAnoModelo());
        dto.setChassi(entity.getChassi());
        dto.setCilindrada(entity.getCilindrada());
        dto.setCor(entity.getCor());
        dto.setDataAquisicao(entity.getDataAquisicao());
        dto.setValorAquisicao(entity.getValorAquisicao());
        dto.setIdTipo(entity.getTipo().getId());
        dto.setIdStatus(entity.getStatus().getId());
        dto.setIdNotaFiscal(entity.getNotaFiscal() != null ? entity.getNotaFiscal().getId() : null);

        return dto;
    }

    public MotoDTO salvar(MotoDTO dto) {
        try {
            return toDTO(motoRepository.save(toEntity(dto)));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao salvar moto", e);
        }
    }

    public MotoDTO buscarPorId(Long id) {
        return motoRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada"));
    }

    public List<MotoDTO> listarTodos() {
        return motoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public MotoDTO atualizar(Long id, MotoDTO dto) {
        if (!motoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada");
        }
        dto.setId(id);
        return toDTO(motoRepository.save(toEntity(dto)));
    }

    public void deletar(Long id) {
        if (!motoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada");
        }
        motoRepository.deleteById(id);
    }
}
