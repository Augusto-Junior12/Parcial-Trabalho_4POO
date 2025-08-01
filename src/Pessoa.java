import java.util.Objects;
import java.util.regex.Pattern;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String email;
    private String senha;

    // Regex simples para e-mail válido
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");

    // Construtor com validação de e-mail
    public Pessoa(int id, String nome, String email, String senha) {

        this.id = id;
        this.nome = nome;
        this.setEmail(email);
        this.senha = senha;
    }

    public void setEmail(String email) {
        if (!EMAIL_REGEX.matcher(email).matches()) {
            throw new IllegalArgumentException("Email inválido!");
        }
        this.email = email;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // equals baseado no id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return id == pessoa.id;
    }

    // toString método para exibir informações da pessoa.
    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
