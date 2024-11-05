import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Assinatura {
    private String tipo;
    private double valor;
    private LocalDate dataAssinatura;
    private String status;
    private Usuario usuario;

    public Assinatura(String tipo, double valor, Usuario usuario) {
        this.tipo = tipo;
        this.valor = valor;
        this.usuario = usuario;
        this.dataAssinatura = LocalDate.now();
        this.status = "Ativa";
    }

    public void ativar() {
        if (status.equals("Expirada") || status.equals("Cancelada")) {
            status = "Ativa";
            dataAssinatura = LocalDate.now();
            System.out.println("Assinatura ativada para " + usuario.getNome());
        } else {
            System.out.println("A assinatura já está ativa.");
        }
    }

    public void renovar() {
        if (status.equals("Ativa")) {
            dataAssinatura = LocalDate.now();
            System.out.println("Assinatura renovada para " + usuario.getNome());
        } else {
            System.out.println("A assinatura está " + status + ", não pode ser renovada.");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String checarStatus() {
        atualizarStatus();
        return status;
    }

    private void atualizarStatus() {
        if (ChronoUnit.DAYS.between(dataAssinatura, LocalDate.now()) > 30 && status.equals("Ativa")) {
            status = "Expirada";
        }
    }
}
