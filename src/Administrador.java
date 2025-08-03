// Herda da classe Pessoa e implementa a interface Autenticavel
public class Administrador extends Pessoa implements Autenticavel {

    // Construtor que utiliza o construtor da superclasse Pessoa
    public Administrador(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    // Autenticação da interface Autenticavel
    // Verifica se a senha informada é igual à senha cadastrada do administrador
    @Override
    public boolean autenticar(String senha) {
        return getSenha().equals(senha);
    }

    // Retorna o nível de acesso associado a um administrador
    @Override
    public Acesso.NivelAcesso getNivelAcesso() {
        return Acesso.NivelAcesso.ADMIN;
    }

    // Metodo permite acessar o painel de controle geral do sistema
    public void acessarControlesGerais() {
        System.out.println(getNome() + " acessou o painel de controle completo.");
    }
}
