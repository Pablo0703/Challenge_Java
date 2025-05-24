package br.com.fiap.ChallengeMottu.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "MOTTU_MOTOCICLISTA")
public class MotociclistaEntity {

    @Id
    @Column(name = "ID_MOTOCICLISTA")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "CPF", nullable = false, length = 11)
    private String cpf;

    @Column(name = "CNH", nullable = false, length = 20)
    private String cnh;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_VALIDADE_CNH", nullable = false)
    private Date dataValidadeCnh;

    @Column(name = "TELEFONE", nullable = false, length = 20)
    private String telefone;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_CADASTRO", nullable = false)
    private Date dataCadastro;

    @Column(name = "ATIVO", length = 1)
    private String ativo;

    @ManyToOne
    @JoinColumn(name = "ID_ENDERECO")
    private EnderecoEntity endereco;

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

    public EnderecoEntity getEndereco() { return endereco; }
    public void setEndereco(EnderecoEntity endereco) { this.endereco = endereco; }
}
