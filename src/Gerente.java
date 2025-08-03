public class Gerente extends Pessoa {

    public Gerente(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    @Override
    public boolean autenticar(String senha) {
        return getSenha().equals(senha);
    }

    @Override
    public Acesso.NivelAcesso getNivelAcesso() {
        return Acesso.NivelAcesso.GERENTE;
    }

    public void gerenciar() {
        System.out.println(getNome() + " está gerenciando a equipe.");
    }
}
