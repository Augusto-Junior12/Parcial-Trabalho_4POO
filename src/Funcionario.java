// A classe Funcionario herda de Pessoa e implementa a interface Autenticavel
public class Funcionario extends Pessoa implements Autenticavel {

    // Construtor que utiliza o construtor da superclasse Pessoa
    public Funcionario(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    // Implementação da autenticação da interface Autenticavel
    @Override
    public boolean autenticar(String senha) {
        // Verifica se a senha passada é igual à senha armazenada
        return getSenha().equals(senha);
    }

    // Retorna o nível de acesso do funcionário
    @Override
    public Acesso.NivelAcesso getNivelAcesso() {
        return Acesso.NivelAcesso.FUNCIONARIO;
    }

    // Metodo que simula o acesso do funcionário ao sistema
    public void acessarSistema() {
        System.out.println(getNome() + " acessou o sistema.");
    }
}
