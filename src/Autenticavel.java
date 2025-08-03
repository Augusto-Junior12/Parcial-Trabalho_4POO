// Interface que define o comportamento de autenticação para classes que a implementarem
public interface Autenticavel {

    // Responsável por autenticar o usuário com base em uma senha informada
    // Retorna true se ou false
    public boolean autenticar(String senha);

    // Retorna o nível de acesso do usuário autenticado (ADMIN, GERENTE, FUNCIONARIO ou VISITANTE)
    Acesso.NivelAcesso getNivelAcesso();

}
