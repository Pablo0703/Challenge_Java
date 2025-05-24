package br.com.fiap.ChallengeMottu.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class NotaFiscalDTO {

    private Long id;

    @NotBlank
    @Size(max = 20)
    private String numero;

    @NotBlank
    @Size(max = 5)
    private String serie;

    @NotBlank
    @Size(max = 2)
    private String modelo;

    @Size(max = 44)
    private String chaveAcesso;

    @NotNull
    private Date dataEmissao;

    @NotNull
    private Double valorTotal;

    @NotBlank
    @Size(max = 100)
    private String fornecedor;

    @NotBlank
    @Size(max = 14)
    private String cnpjFornecedor;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getChaveAcesso() { return chaveAcesso; }
    public void setChaveAcesso(String chaveAcesso) { this.chaveAcesso = chaveAcesso; }

    public Date getDataEmissao() { return dataEmissao; }
    public void setDataEmissao(Date dataEmissao) { this.dataEmissao = dataEmissao; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public String getFornecedor() { return fornecedor; }
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }

    public String getCnpjFornecedor() { return cnpjFornecedor; }
    public void setCnpjFornecedor(String cnpjFornecedor) { this.cnpjFornecedor = cnpjFornecedor; }
}
