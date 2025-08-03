// Herda da classe Pessoa e implementa a interface Autenticavel.
public class Visitante extends Pessoa implements Autenticavel {

    // Construtor que utiliza o construtor da superclasse Pessoa.
    public Visitante(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    // Autenticação da interface Autenticavel
    // Para visitantes a autenticação sempre falha, pois não têm permissão de login
    @Override
    public boolean autenticar(String senha) {
        // Visitante não tem permissão para autenticação real
        return false;
    }

    // Retorna o nível de acesso associado a um visitante
    @Override
    public Acesso.NivelAcesso getNivelAcesso() {
        return Acesso.NivelAcesso.VISITANTE;
    }

    // Metodo específico do visitante que apenas "visita" o sistema
    public void vistar() {
        System.out.println(getNome() + " está visitando o sistema.");
    }
}
