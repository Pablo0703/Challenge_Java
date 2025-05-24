package br.com.fiap.ChallengeMottu.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MOTTU_FILIAL")
public class FilialEntity {

    @Id
    @Column(name = "ID_FILIAL")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "CNPJ", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "TELEFONE", length = 20)
    private String telefone;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "ATIVO", length = 1)
    private String ativo;

    @ManyToOne
    @JoinColumn(name = "ID_ENDERECO", nullable = false)
    private EnderecoEntity endereco;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAtivo() { return ativo; }
    public void setAtivo(String ativo) { this.ativo = ativo; }

    public EnderecoEntity getEndereco() { return endereco; }
    public void setEndereco(EnderecoEntity endereco) { this.endereco = endereco; }
}
