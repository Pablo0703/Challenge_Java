package br.com.fiap.ChallengeMottu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MOTTU_ENDERECO")
public class EnderecoEntity {

    @Id
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Column(name = "LOGRADOURO", nullable = false, length = 50)
    private String logradouro;

    @Column(name = "NUMERO", nullable = false, length = 10)
    private String numero;

    @Column(name = "COMPLEMENTO", length = 50)
    private String complemento;

    @Column(name = "BAIRRO", nullable = false, length = 50)
    private String bairro;

    @Column(name = "CEP", nullable = false, length = 10)
    private String cep;

    @Column(name = "CIDADE", nullable = false, length = 50)
    private String cidade;

    @Column(name = "ESTADO", nullable = false, length = 2)
    private String estado;

    @Column(name = "PAIS", length = 50)
    private String pais;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
}
