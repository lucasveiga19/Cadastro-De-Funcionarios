package Model;

public class Funcionarios {

    private Long codigo;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String genero;
    private String nomeMae;
    private boolean efetivo;

    @Override
    public String toString() {
        return "Funcionarios Registrados" +
                " Codigo = " + codigo +
                ", Nome = '" + nome + '\'' +
                ", CPF = '" + cpf + '\'' +
                ", Data de Nascimento = '" + dataNascimento + '\'' +
                ", Gênero = '" + genero + '\'' +
                ", Nome da Mãe = '" + nomeMae + '\'' +
                ", Efetivado = " + efetivo +
                '}';
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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
