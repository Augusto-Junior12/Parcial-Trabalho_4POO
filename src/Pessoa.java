import java.util.Objects;
import java.util.regex.Pattern;

// Classe abstrata que serve de base para outras classes como Funcionario, Administrador, etc.
public abstract class Pessoa {
    // Atributos das pessoas que utilizaram o sistema
    private int id;
    private String nome;
    private String email;
    private String senha;

    // Validação o por Regex do e-mail
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");

    // Construtor da classe Pessoa com validação do e-mail
    public Pessoa(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.setEmail(email);  // Usa o setter para validar o e-mail
        this.senha = senha;
    }

    // Metodo para validar e definir o e-mail
    public void setEmail(String email) {
        if (!EMAIL_REGEX.matcher(email).matches()) {
            throw new IllegalArgumentException("Email inválido!");
        }
        this.email = email;
    }

    // Getters e setters
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

    // Equals sobrescrito para comparar objetos Pessoa com base no ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Se for o mesmo objeto, retorna true
        if (obj == null || getClass() != obj.getClass()) return false;  // Verifica tipo
        Pessoa pessoa = (Pessoa) obj;
        return id == pessoa.id;  // Compara apenas os IDs
    }

    // ToString sobrescrito para exibir os dados da pessoa
    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
