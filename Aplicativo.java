import java.util.Date;

public class Aplicativo extends Produto {
    private double tamanho;
    private String desenvolvedor;
    private Date dataPublicacao;
    private int downloads;

    public Aplicativo(String nome, double tamanho, String desenvolvedor, String categoria) {
        super(nome, categoria);
        this.tamanho = tamanho;
        this.desenvolvedor = desenvolvedor;
        this.dataPublicacao = new Date();
        this.downloads = 0;
    }

    @Override
    public void calcularAvaliacaoMedia() {
        if (!reviews.isEmpty()) {
            double total = 0;
            for (Review review : reviews) {
                total += review.getNota();
            }
            avaliacaoMedia = total / reviews.size();
        }
    }

    @Override
    public void baixar() {
        downloads++;
        System.out.println("Aplicativo " + getNome() + " baixado com sucesso.");
    }

    @Override
    public void abrir() {
        System.out.println("Abrindo o aplicativo " + getNome());
    }

    public double getTamanho() {
        return tamanho;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public int getDownloads() {
        return downloads;
    }
}
