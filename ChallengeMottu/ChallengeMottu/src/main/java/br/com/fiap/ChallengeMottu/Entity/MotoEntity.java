package br.com.fiap.ChallengeMottu.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MOTTU_MOTO")
public class MotoEntity {

    @Id
    @Column(name = "ID_MOTO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO", nullable = false)
    private TipoMotoEntity tipo;

    @ManyToOne
    @JoinColumn(name = "ID_STATUS", nullable = false)
    private StatusMotoEntity status;

    @Column(name = "PLACA", nullable = false, length = 10)
    private String placa;

    @Column(name = "MODELO", nullable = false, length = 50)
    private String modelo;

    @Column(name = "ANO_FABRICACAO", nullable = false)
    private Integer anoFabricacao;

    @Column(name = "ANO_MODELO", nullable = false)
    private Integer anoModelo;

    @Column(name = "CHASSI", nullable = false, length = 17)
    private String chassi;

    @Column(name = "CILINDRADA", nullable = false)
    private Integer cilindrada;

    @Column(name = "COR", nullable = false, length = 20)
    private String cor;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_AQUISICAO", nullable = false)
    private Date dataAquisicao;

    @Column(name = "VALOR_AQUISICAO", nullable = false)
    private Double valorAquisicao;

    @ManyToOne
    @JoinColumn(name = "ID_NF")
    private NotaFiscalEntity notaFiscal;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TipoMotoEntity getTipo() { return tipo; }
    public void setTipo(TipoMotoEntity tipo) { this.tipo = tipo; }

    public StatusMotoEntity getStatus() { return status; }
    public void setStatus(StatusMotoEntity status) { this.status = status; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Integer getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(Integer anoFabricacao) { this.anoFabricacao = anoFabricacao; }

    public Integer getAnoModelo() { return anoModelo; }
    public void setAnoModelo(Integer anoModelo) { this.anoModelo = anoModelo; }

    public String getChassi() { return chassi; }
    public void setChassi(String chassi) { this.chassi = chassi; }

    public Integer getCilindrada() { return cilindrada; }
    public void setCilindrada(Integer cilindrada) { this.cilindrada = cilindrada; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public Date getDataAquisicao() { return dataAquisicao; }
    public void setDataAquisicao(Date dataAquisicao) { this.dataAquisicao = dataAquisicao; }

    public Double getValorAquisicao() { return valorAquisicao; }
    public void setValorAquisicao(Double valorAquisicao) { this.valorAquisicao = valorAquisicao; }

    public NotaFiscalEntity getNotaFiscal() { return notaFiscal; }
    public void setNotaFiscal(NotaFiscalEntity notaFiscal) { this.notaFiscal = notaFiscal; }
}
