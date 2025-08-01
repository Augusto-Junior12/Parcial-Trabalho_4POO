public class Funcionario extends Pessoa implements Autenticavel {

    public Funcionario(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    @Override
    public boolean autenticar(String senha) {
        return getSenha().equals(senha);
    }

    @Override
    public Acesso.NivelAcesso getNivelAcesso() {
        return Acesso.NivelAcesso.FUNCIONARIO;
    }

    public void acessarSistema() {
        System.out.println(getNome() + " acessou o sistema.");
    }
}
