import java.util.ArrayList;
import java.util.List;

public class Usuario extends UsuarioBase {
    private List<Aplicativo> historicoDownloads;
    private List<Assinatura> assinaturas;

    public Usuario(String nome, String email, String senha) {
        super(nome, email, senha);
        this.historicoDownloads = new ArrayList<>();
        this.assinaturas = new ArrayList<>();
    }

    @Override
    public void escreverReview(Aplicativo app, String texto, int nota) {
        if (isLogado()) {
            Review review = new Review(this, app, texto, nota);
            app.receberReview(review);
            System.out.println("Review adicionado para o aplicativo: " + app.getNome());
        } else {
            System.out.println("Faça login para escrever uma review.");
        }
    }

    public void baixarAplicativo(Aplicativo app) {
        if (isLogado()) {
            app.baixar();
            historicoDownloads.add(app);
            System.out.println("Aplicativo " + app.getNome() + " baixado com sucesso.");
        } else {
            System.out.println("Faça login para baixar aplicativos.");
        }
    }

    public List<Aplicativo> getHistoricoDownloads() {
        return new ArrayList<>(historicoDownloads);
    }

    public void assinar(Assinatura assinatura) {
        if (!assinaturas.contains(assinatura)) {
            assinaturas.add(assinatura);
            assinatura.ativar();
        }
    }
}
