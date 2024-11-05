import java.util.ArrayList;
import java.util.List;

public class Desenvolvedor extends Usuario {
    private double saldo;
    private List<Aplicativo> aplicativosPublicados;

    public Desenvolvedor(String nome, String email, String senha) {
        super(nome, email, senha);
        this.saldo = 0.0;
        this.aplicativosPublicados = new ArrayList<>();
    }

    public void publicarApp(Aplicativo app) {
        if (app != null) {
            aplicativosPublicados.add(app);
            System.out.println("Aplicativo '" + app.getNome() + "' publicado com sucesso.");
        }
    }

    public void consultarRelatoriosVendas() {
        System.out.println("Relatório de vendas:");
        for (Aplicativo app : aplicativosPublicados) {
            System.out.println("Aplicativo: " + app.getNome() + " | Downloads: " + app.getDownloads());
        }
        System.out.println("Saldo total: R$" + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}
