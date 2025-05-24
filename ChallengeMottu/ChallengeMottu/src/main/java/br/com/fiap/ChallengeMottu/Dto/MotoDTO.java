package br.com.fiap.ChallengeMottu.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class MotoDTO {

    private Long id;

    @NotNull
    private Long idTipo;

    @NotNull
    private Long idStatus;

    @NotBlank
    @Size(max = 10)
    private String placa;

    @NotBlank
    @Size(max = 50)
    private String modelo;

    @NotNull
    private Integer anoFabricacao;

    @NotNull
    private Integer anoModelo;

    @NotBlank
    @Size(max = 17)
    private String chassi;

    @NotNull
    private Integer cilindrada;

    @NotBlank
    @Size(max = 20)
    private String cor;

    @NotNull
    private Date dataAquisicao;

    @NotNull
    private Double valorAquisicao;

    private Long idNotaFiscal;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdTipo() { return idTipo; }
    public void setIdTipo(Long idTipo) { this.idTipo = idTipo; }

    public Long getIdStatus() { return idStatus; }
    public void setIdStatus(Long idStatus) { this.idStatus = idStatus; }

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

    public Long getIdNotaFiscal() { return idNotaFiscal; }
    public void setIdNotaFiscal(Long idNotaFiscal) { this.idNotaFiscal = idNotaFiscal; }
}
