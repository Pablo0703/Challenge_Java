package br.com.fiap.ChallengeMottu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MOTTU_STATUS_MOTO")
public class StatusMotoEntity {

    @Id
    @Column(name = "ID_STATUS")
    private Long id;

    @Column(name = "DESCRICAO", nullable = false, length = 20)
    private String descricao;

    @Column(name = "DISPONIVEL", length = 1)
    private String disponivel;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getDisponivel() { return disponivel; }
    public void setDisponivel(String disponivel) { this.disponivel = disponivel; }
}
