import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogAcesso {
    private int idPessoa;
    private LocalDateTime dataHora;
    private String resultado;
    private String area;
    DateTimeFormatter modeloDH = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // construtor para gerar um login
    public LogAcesso(String area, int idPessoa, boolean resultado) {
        this.area = area;
        this.idPessoa = idPessoa;
        this.resultado = resultado ? "Permitido" : "Negado";
        this.dataHora = LocalDateTime.now();
    }

    // metodo toString para retornar a string de acesso formatada
    @Override
    public String toString() {
        return "Registro de Acesso -> " + "ID Pessoa: " + idPessoa + " | Área: " + area + " | Acesso: " + resultado + " | Data/Horário=" + dataHora.format(modeloDH);
    }

    // getters e setters
    public int getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public String getResultado() {
        return resultado;
    }
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
