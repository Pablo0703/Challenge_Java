package br.com.fiap.ChallengeMottu.Dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class LocalizacaoMotoDTO {

    private Long id;

    @NotNull
    private Long idMoto;

    @NotNull
    private Long idZona;

    @NotNull
    private Date dataHoraEntrada;

    private Date dataHoraSaida;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdMoto() { return idMoto; }
    public void setIdMoto(Long idMoto) { this.idMoto = idMoto; }

    public Long getIdZona() { return idZona; }
    public void setIdZona(Long idZona) { this.idZona = idZona; }

    public Date getDataHoraEntrada() { return dataHoraEntrada; }
    public void setDataHoraEntrada(Date dataHoraEntrada) { this.dataHoraEntrada = dataHoraEntrada; }

    public Date getDataHoraSaida() { return dataHoraSaida; }
    public void setDataHoraSaida(Date dataHoraSaida) { this.dataHoraSaida = dataHoraSaida; }
}
