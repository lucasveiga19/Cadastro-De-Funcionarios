package Model;

import java.util.Date;

public class Funcionarios {

    private Long codigo;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String genero;
    private String nomeMae;
    private Boolean efetivo;

    public Funcionarios(Long codigo, String nome, String cpf, Date dataNascimento, String genero, String nomeMae, Boolean efetivo) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.nomeMae = nomeMae;
        this.efetivo = efetivo;
    }

    public Funcionarios() {
    }

    @Override
    public String toString() {
        return "Funcionario Registrado:" +
                " Codigo = " + codigo +
                ", Nome = '" + nome + '\'' +
                ", CPF = '" + cpf + '\'' +
                ", Data de Nascimento = '" + dataNascimento + '\'' +
                ", Gênero = '" + genero + '\'' +
                ", Nome da Mãe = '" + nomeMae + '\'' +
                ", Efetivado = " + efetivo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public boolean isEfetivo() {
        return efetivo;
    }

    public void setEfetivo(boolean efetivo) {
        this.efetivo = efetivo;
    }
}
