package br.com.fiap.ChallengeMottu.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MOTTU_LOCALIZACAO_MOTO")
public class LocalizacaoMotoEntity {

    @Id
    @Column(name = "ID_LOCALIZACAO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_MOTO", nullable = false)
    private MotoEntity moto;

    @ManyToOne
    @JoinColumn(name = "ID_ZONA", nullable = false)
    private ZonaPatioEntity zonaPatio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_HORA_ENTRADA", nullable = false)
    private Date dataHoraEntrada;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_HORA_SAIDA")
    private Date dataHoraSaida;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public MotoEntity getMoto() { return moto; }
    public void setMoto(MotoEntity moto) { this.moto = moto; }

    public ZonaPatioEntity getZonaPatio() { return zonaPatio; }
    public void setZonaPatio(ZonaPatioEntity zonaPatio) { this.zonaPatio = zonaPatio; }

    public Date getDataHoraEntrada() { return dataHoraEntrada; }
    public void setDataHoraEntrada(Date dataHoraEntrada) { this.dataHoraEntrada = dataHoraEntrada; }

    public Date getDataHoraSaida() { return dataHoraSaida; }
    public void setDataHoraSaida(Date dataHoraSaida) { this.dataHoraSaida = dataHoraSaida; }
}
