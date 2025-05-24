package br.com.fiap.ChallengeMottu.Dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public class HistoricoLocalizacaoDTO {

    private Long id;

    @NotNull
    private Long idMoto;

    private Long idMotociclista;

    private Long idZonaPatio;

    @NotNull
    private Date dataHoraSaida;

    private Date dataHoraEntrada;

    private BigDecimal kmRodados;

    private Long idStatusOperacao;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdMoto() { return idMoto; }
    public void setIdMoto(Long idMoto) { this.idMoto = idMoto; }

    public Long getIdMotociclista() { return idMotociclista; }
    public void setIdMotociclista(Long idMotociclista) { this.idMotociclista = idMotociclista; }

    public Long getIdZonaPatio() { return idZonaPatio; }
    public void setIdZonaPatio(Long idZonaPatio) { this.idZonaPatio = idZonaPatio; }

    public Date getDataHoraSaida() { return dataHoraSaida; }
    public void setDataHoraSaida(Date dataHoraSaida) { this.dataHoraSaida = dataHoraSaida; }

    public Date getDataHoraEntrada() { return dataHoraEntrada; }
    public void setDataHoraEntrada(Date dataHoraEntrada) { this.dataHoraEntrada = dataHoraEntrada; }

    public BigDecimal getKmRodados() { return kmRodados; }
    public void setKmRodados(BigDecimal kmRodados) { this.kmRodados = kmRodados; }

    public Long getIdStatusOperacao() { return idStatusOperacao; }
    public void setIdStatusOperacao(Long idStatusOperacao) { this.idStatusOperacao = idStatusOperacao; }
}
