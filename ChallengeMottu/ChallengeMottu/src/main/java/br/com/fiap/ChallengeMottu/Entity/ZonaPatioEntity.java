package br.com.fiap.ChallengeMottu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MOTTU_ZONA_PATIO")
public class ZonaPatioEntity {

    @Id
    @Column(name = "ID_ZONA")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PATIO", nullable = false)
    private PatioEntity patio;

    @Column(name = "NOME_ZONA", nullable = false, length = 30)
    private String nomeZona;

    @Column(name = "TIPO_ZONA", nullable = false, length = 20)
    private String tipoZona;

    @Column(name = "CAPACIDADE", nullable = false)
    private Integer capacidade;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public PatioEntity getPatio() { return patio; }
    public void setPatio(PatioEntity patio) { this.patio = patio; }

    public String getNomeZona() { return nomeZona; }
    public void setNomeZona(String nomeZona) { this.nomeZona = nomeZona; }

    public String getTipoZona() { return tipoZona; }
    public void setTipoZona(String tipoZona) { this.tipoZona = tipoZona; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }
}
