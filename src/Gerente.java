// Herda da classe Pessoa e implementa a interface Autenticavel
public class Gerente extends Pessoa implements Autenticavel {

    // Construtor que utiliza o construtor da superclasse Pessoa
    public Gerente(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    // Autenticação da interface Autenticavel
    // Verifica se a senha informada é igual à senha cadastrada do gerente
    @Override
    public boolean autenticar(String senha) {
        return getSenha().equals(senha);
    }

    // Retorna o nível de acesso associado a um gerente
    @Override
    public Acesso.NivelAcesso getNivelAcesso() {
        return Acesso.NivelAcesso.GERENTE;
    }

    // Metodo específico do gerente para gerenciar a equipe.
    public void gerenciar() {
        System.out.println(getNome() + " está gerenciando a equipe.");
    }
}
