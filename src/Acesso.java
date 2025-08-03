public class Acesso {

    // Enum que define os diferentes níveis de acesso no sistema
    public enum NivelAcesso {
        ADMIN,       // Nível de acesso de administrador, com permissões máximas
        GERENTE,     // Nível de acesso de gerente, permissões intermediárias
        FUNCIONARIO, // Nível de acesso de funcionário, permissões básicas
        VISITANTE    // Nível de acesso de visitante, permissões mínimas ou restritas
    }

}
