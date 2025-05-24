package br.com.fiap.ChallengeMottu.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MOTTU_HISTORICO_LOCALIZACAO")
public class HistoricoLocalizacaoEntity {

    @Id
    @Column(name = "ID_HISTORICO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_MOTO", nullable = false)
    private MotoEntity moto;

    @ManyToOne
    @JoinColumn(name = "ID_MOTOCICLISTA")
    private MotociclistaEntity motociclista;

    @ManyToOne
    @JoinColumn(name = "ID_ZONA_PATIO")
    private ZonaPatioEntity zonaPatio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_HORA_SAIDA", nullable = false)
    private Date dataHoraSaida;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_HORA_ENTRADA")
    private Date dataHoraEntrada;

    @Column(name = "KM_RODADOS", precision = 10, scale = 2)
    private BigDecimal kmRodados;

    @ManyToOne
    @JoinColumn(name = "ID_STATUS_OPERACAO")
    private StatusOperacaoEntity statusOperacao;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public MotoEntity getMoto() { return moto; }
    public void setMoto(MotoEntity moto) { this.moto = moto; }

    public MotociclistaEntity getMotociclista() { return motociclista; }
    public void setMotociclista(MotociclistaEntity motociclista) { this.motociclista = motociclista; }

    public ZonaPatioEntity getZonaPatio() { return zonaPatio; }
    public void setZonaPatio(ZonaPatioEntity zonaPatio) { this.zonaPatio = zonaPatio; }

    public Date getDataHoraSaida() { return dataHoraSaida; }
    public void setDataHoraSaida(Date dataHoraSaida) { this.dataHoraSaida = dataHoraSaida; }

    public Date getDataHoraEntrada() { return dataHoraEntrada; }
    public void setDataHoraEntrada(Date dataHoraEntrada) { this.dataHoraEntrada = dataHoraEntrada; }

    public BigDecimal getKmRodados() { return kmRodados; }
    public void setKmRodados(BigDecimal kmRodados) { this.kmRodados = kmRodados; }

    public StatusOperacaoEntity getStatusOperacao() { return statusOperacao; }
    public void setStatusOperacao(StatusOperacaoEntity statusOperacao) { this.statusOperacao = statusOperacao; }
}
