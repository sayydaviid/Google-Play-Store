import java.util.ArrayList;
import java.util.List;

public class SuperUsuario extends Usuario {
    private List<String> atividadesMonitoradas;

    public SuperUsuario(String nome, String email, String senha) {
        super(nome, email, senha);
        this.atividadesMonitoradas = new ArrayList<>();
    }

    public void aprovarApp(Aplicativo app) {
        System.out.println("Aplicativo " + app.getNome() + " aprovado.");
    }

    public void suspenderUsuario(Usuario usuario) {
        System.out.println("Usuário " + usuario.getNome() + " suspenso.");
    }

    public void visualizarAtividades() {
        System.out.println("Atividades monitoradas:");
        for (String atividade : atividadesMonitoradas) {
            System.out.println("- " + atividade);
        }
    }

    public void adicionarAtividadeMonitorada(String atividade) {
        atividadesMonitoradas.add(atividade);
    }
}
