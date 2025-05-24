package br.com.fiap.ChallengeMottu.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MOTTU_NF")
public class NotaFiscalEntity {

    @Id
    @Column(name = "ID_NF")
    private Long id;

    @Column(name = "NUMERO", nullable = false, length = 20)
    private String numero;

    @Column(name = "SERIE", nullable = false, length = 5)
    private String serie;

    @Column(name = "MODELO", nullable = false, length = 2)
    private String modelo;

    @Column(name = "CHAVE_ACESSO", length = 44)
    private String chaveAcesso;

    @Column(name = "DATA_EMISSAO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private Double valorTotal;

    @Column(name = "FORNECEDOR", nullable = false, length = 100)
    private String fornecedor;

    @Column(name = "CNPJ_FORNECEDOR", nullable = false, length = 14)
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
