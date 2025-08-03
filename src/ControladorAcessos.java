import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControladorAcessos {
    private Map<Integer, Pessoa> pessoas = new HashMap<>();
    private Map<String, AreaRestrita> areas = new HashMap<>();
    private List<LogAcesso> logs = new ArrayList<>();

    // Lê o arquivo CSV de pessoas e cria instâncias com base no nível de acesso informado
    public void carregarPessoas(String path) {
        try {
            // Lê todas as linhas do arquivo PATH e separa em partes usando split
            List<String> linhas = Files.readAllLines(Paths.get(path));
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String email = partes[2];
                String senha = partes[3];
                String cargo = partes[4];

                // instancia as pessoas
                Pessoa p;
                switch (cargo.toUpperCase()) {
                    case "VISITANTE": p = new Visitante(id, nome, email, senha); break;
                    case "FUNCIONARIO": p = new Funcionario(id, nome, email, senha); break;
                    case "GERENTE": p = new Gerente(id, nome, email, senha); break;
                    case "ADMINISTRADOR": p = new Administrador(id, nome, email, senha); break;
                    default: throw new IllegalArgumentException("Cargo inválido: " + cargo);
                }
                pessoas.put(id, p); // salva no hashmap
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar pessoas: " + e.getMessage());
        }
    }

    public void carregarAreas(String path) {
        try {
            // Lê todas as linhas do arquivo PATH e separa em partes usando split
            List<String> linhas = Files.readAllLines(Paths.get(path));
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                String nomeArea = partes[0];
                Acesso.NivelAcesso nivelMinimoAcesso = Acesso.NivelAcesso.valueOf(partes[1].toUpperCase());
                // instancia as areas
                AreaRestrita area = new AreaRestrita(nomeArea, nivelMinimoAcesso);
                areas.put(nomeArea, area); // salva no hashmap
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar áreas: " + e.getMessage());
        }
    }

    public void registrarAcesso(String idPessoa, String area) {
        try {
            int idPessoaint = Integer.parseInt(idPessoa);
            Pessoa p = pessoas.get(idPessoaint);
            AreaRestrita nomeArea = areas.get(area);

            if (p == null || area == null) {
                System.out.println("Pessoa ou área não encontrada.");
                return;
            }

            // Registra a tentativa na área e adiciona a prha o ultimo log adicionado da área na lista de log desta classe
            nomeArea.registrarTentativa(p);
            logs.add(nomeArea.getLogs().get(nomeArea.getLogs().size() - 1)); // último log da área
        } catch (Exception e) {
            System.out.println("Erro ao registrar acesso: " + e.getMessage());
        }
    }

    // filtra os logs pelo resultado(permitido/negado) e ignora se esta maiuscula ou minuscula usando o equalsIgnoreCase
    public List<LogAcesso> filtrarPorResultado(String resultado) {
        return logs.stream()
                .filter(log -> log.getResultado().equalsIgnoreCase(resultado))
                .collect(Collectors.toList());
    }

    // conta quantas vezes cada pessoa tentou acessar o sistema usando o id convertido para string pelo prefixo "Pessoa ID:"
    public Map<String, Long> contarTentativasPorPessoa() {
        return logs.stream()
                .collect(Collectors.groupingBy(log -> "Pessoa ID: " + log.getIdPessoa(), Collectors.counting()));
    } // ele usa o Collectors.counting() para contar quantos logs existem com aquele ID

    // gera um arquivo de texto com o histórico de acessos registrados no sistema
    public void salvarRelatorio(String path) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
            writer.write("=== RELATÓRIO DE ACESSOS ===\n");
            for (LogAcesso log : logs) {
                writer.write(log.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar relatório: " + e.getMessage());
        }
    }
}
