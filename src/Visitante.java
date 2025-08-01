public class Visitante extends Pessoa implements Autenticavel {

    public Visitante(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    @Override
    public boolean autenticar(String senha) {
        // Visitante não tem permissão para autenticação real
        return false;
    }

    @Override
    public Acesso.NivelAcesso getNivelAcesso() {
        return Acesso.NivelAcesso.VISITANTE;
    }

    public void vistar() {
        System.out.println(getNome() + " está visitando o sistema.");
    }
}
