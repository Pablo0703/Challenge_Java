package br.com.fiap.ChallengeMottu.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EnderecoDTO {

    private Long id;

    @NotBlank @Size(max = 50)
    private String logradouro;

    @NotBlank @Size(max = 10)
    private String numero;

    @Size(max = 50)
    private String complemento;

    @NotBlank @Size(max = 50)
    private String bairro;

    @NotBlank @Size(max = 10)
    private String cep;

    @NotBlank @Size(max = 50)
    private String cidade;

    @NotBlank @Size(max = 2)
    private String estado;

    @Size(max = 50)
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
