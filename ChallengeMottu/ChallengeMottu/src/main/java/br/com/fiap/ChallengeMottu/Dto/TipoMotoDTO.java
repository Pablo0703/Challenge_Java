package br.com.fiap.ChallengeMottu.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TipoMotoDTO {

    private Long id;

    @NotBlank
    @Size(max = 60)
    private String descricao;

    @NotBlank
    @Size(max = 30)
    private String categoria;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
