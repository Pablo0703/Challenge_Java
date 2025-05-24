package br.com.fiap.ChallengeMottu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MOTTU_TIPO_MOTO")
public class TipoMotoEntity {

    @Id
    @Column(name = "ID_TIPO")
    private Long id;

    @Column(name = "DESCRICAO", nullable = false, length = 60)
    private String descricao;

    @Column(name = "CATEGORIA", nullable = false, length = 30)
    private String categoria;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
