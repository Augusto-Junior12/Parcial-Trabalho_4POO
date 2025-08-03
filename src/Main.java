public class Main {
    public static void main(String[] args) {
        ControladorAcessos controlador = new ControladorAcessos();

        // Carrega pessoas e áreas a partir dos arquivos CSV
        controlador.carregarPessoas("pessoas.csv");
        controlador.carregarAreas("areas.csv");

        // Registra tentativas de acesso
        controlador.registrarAcesso("1", "Auditório");          // Harry → permitido
        controlador.registrarAcesso("1", "Sala de Servidores"); // Harry → negado
        controlador.registrarAcesso("2", "Sala de Reunião");    // José → permitido
        controlador.registrarAcesso("3", "Sala de Servidores"); // Vini → negado
        controlador.registrarAcesso("4", "Sala de Servidores"); // Kaiser → permitido

        // Filtra por resultado
        System.out.println("\n=== Acessos PERMITIDOS ===");
        controlador.filtrarPorResultado("PERMITIDO").forEach(System.out::println);

        System.out.println("\n=== Acessos NEGADOS ===");
        controlador.filtrarPorResultado("NEGADO").forEach(System.out::println);

        // Conta tentativas por pessoa
        System.out.println("\n=== Tentativas por Pessoa ===");
        controlador.contarTentativasPorPessoa().forEach((id, total) ->
                System.out.println(id + " → " + total + " tentativa(s)")
        );

        // Salva relatório geral
        controlador.salvarRelatorio("relatorio.txt");
        System.out.println("\nRelatório salvo com sucesso!");
    }
}