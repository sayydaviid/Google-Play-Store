import java.util.ArrayList;
import java.util.List;

public abstract class Produto implements Baixavel {
    private String nome;
    private String categoria;
    protected List<Review> reviews;
    protected double avaliacaoMedia;

    public Produto(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
        this.reviews = new ArrayList<>();
        this.avaliacaoMedia = 0.0;
    }

    public void receberReview(Review review) {
        reviews.add(review);
        calcularAvaliacaoMedia();
    }

    public abstract void calcularAvaliacaoMedia();

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getAvaliacaoMedia() {
        return avaliacaoMedia;
    }
}
