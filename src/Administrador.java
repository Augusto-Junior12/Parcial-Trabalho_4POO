public class Administrador extends Pessoa implements Autenticavel {

    public Administrador(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    @Override
    public boolean autenticar(String senha) {
        return getSenha().equals(senha);
    }

    @Override
    public Acesso.NivelAcesso getNivelAcesso() {
        return Acesso.NivelAcesso.ADMIN;
    }

    public void acessarControlesGerais() {
        System.out.println(getNome() + " acessou o painel de controle completo.");
    }
}
