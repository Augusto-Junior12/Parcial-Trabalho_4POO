import java.util.ArrayList;
import java.util.List;

public class AreaRestrita {
    private String nomeArea;
    private Acesso.NivelAcesso nivelMinimoAcesso;
    List<LogAcesso> logs;

    // registra a tentativa de acesso da pessoa na Área
    public void registrarTentativa(Pessoa p) {
        boolean permissao = p.getNivelAcesso().ordinal() <= nivelMinimoAcesso.ordinal();
        LogAcesso log = new LogAcesso(this.getNomeArea(), p.getId(), permissao);
        logs.add(log);
        System.out.println(log.toString());
    }

    // contrutor da classe para adição de uma Área
    public AreaRestrita(String nomeArea, Acesso.NivelAcesso nivelMinimoAcesso) {
        this.nomeArea = nomeArea;
        this.nivelMinimoAcesso = nivelMinimoAcesso;
        this.logs = new ArrayList<>();
    }

    // getters e setters
    public String getNomeArea() {
        return nomeArea;
    }
    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    public Acesso.NivelAcesso getNivelMinimoAcesso() {
        return nivelMinimoAcesso;
    }
    public void setNivelMinimoAcesso(Acesso.NivelAcesso nivelMinimoAcesso) {
        this.nivelMinimoAcesso = nivelMinimoAcesso;
    }

    public List<LogAcesso> getLogs() {
        return logs;
    }
    public void setLogs(List<LogAcesso> logs) {
        this.logs = logs;
    }
}
