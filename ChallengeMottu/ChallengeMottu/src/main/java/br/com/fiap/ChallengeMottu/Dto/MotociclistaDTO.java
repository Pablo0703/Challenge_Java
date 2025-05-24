package br.com.fiap.ChallengeMottu.Dto;

import jakarta.validation.constraints.*;

import java.util.Date;

public class MotociclistaDTO {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 20)
    private String cnh;

    @NotNull
    private Date dataValidadeCnh;

    @NotBlank
    @Size(max = 20)
    private String telefone;

    @Size(max = 100)
    private String email;

    @NotNull
    private Date dataCadastro;

    @Size(max = 1)
    private String ativo;

    private Long idEndereco;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCnh() { return cnh; }
    public void setCnh(String cnh) { this.cnh = cnh; }

    public Date getDataValidadeCnh() { return dataValidadeCnh; }
    public void setDataValidadeCnh(Date dataValidadeCnh) { this.dataValidadeCnh = dataValidadeCnh; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(Date dataCadastro) { this.dataCadastro = dataCadastro; }

    public String getAtivo() { return ativo; }
    public void setAtivo(String ativo) { this.ativo = ativo; }

    public Long getIdEndereco() { return idEndereco; }
    public void setIdEndereco(Long idEndereco) { this.idEndereco = idEndereco; }
}
