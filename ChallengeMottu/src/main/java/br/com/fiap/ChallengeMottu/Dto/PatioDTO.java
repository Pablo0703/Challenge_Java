package br.com.fiap.ChallengeMottu.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatioDTO {

    private Long id;

    @NotNull
    private Long idFilial;

    @NotBlank
    @Size(max = 50)
    private String nome;

    private Double areaM2;

    @NotNull
    private Integer capacidade;

    @Size(max = 1)
    private String ativo;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdFilial() { return idFilial; }
    public void setIdFilial(Long idFilial) { this.idFilial = idFilial; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getAreaM2() { return areaM2; }
    public void setAreaM2(Double areaM2) { this.areaM2 = areaM2; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }

    public String getAtivo() { return ativo; }
    public void setAtivo(String ativo) { this.ativo = ativo; }
}
