package br.com.fiap.ChallengeMottu.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ZonaPatioDTO {

    private Long id;

    @NotNull
    private Long idPatio;

    @NotBlank
    @Size(max = 30)
    private String nomeZona;

    @NotBlank
    @Size(max = 20)
    private String tipoZona;

    @NotNull
    private Integer capacidade;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdPatio() { return idPatio; }
    public void setIdPatio(Long idPatio) { this.idPatio = idPatio; }

    public String getNomeZona() { return nomeZona; }
    public void setNomeZona(String nomeZona) { this.nomeZona = nomeZona; }

    public String getTipoZona() { return tipoZona; }
    public void setTipoZona(String tipoZona) { this.tipoZona = tipoZona; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }
}
