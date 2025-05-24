package br.com.fiap.ChallengeMottu.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StatusMotoDTO {

    private Long id;

    @NotBlank
    @Size(max = 20)
    private String descricao;

    @Size(max = 1)
    private String disponivel;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getDisponivel() { return disponivel; }
    public void setDisponivel(String disponivel) { this.disponivel = disponivel; }
}
