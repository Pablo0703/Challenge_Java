package br.com.fiap.ChallengeMottu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MOTTU_PATIO")
public class PatioEntity {

    @Id
    @Column(name = "ID_PATIO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_FILIAL", nullable = false)
    private FilialEntity filial;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "AREA_M2")
    private Double areaM2;

    @Column(name = "CAPACIDADE", nullable = false)
    private Integer capacidade;

    @Column(name = "ATIVO", length = 1)
    private String ativo;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public FilialEntity getFilial() { return filial; }
    public void setFilial(FilialEntity filial) { this.filial = filial; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getAreaM2() { return areaM2; }
    public void setAreaM2(Double areaM2) { this.areaM2 = areaM2; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }

    public String getAtivo() { return ativo; }
    public void setAtivo(String ativo) { this.ativo = ativo; }
}
