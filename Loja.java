import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Loja {
    private List<Usuario> usuarios;
    private List<Produto> produtos;
    private List<Assinatura> assinaturas;
    private List<Desenvolvedor> desenvolvedores;

    public Loja() {
        this.usuarios = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.assinaturas = new ArrayList<>();
        this.desenvolvedores = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null) {
            usuarios.add(usuario);
            System.out.println("Usuário " + usuario.getNome() + " adicionado à loja.");
        }
    }

    public void adicionarDesenvolvedor(Desenvolvedor desenvolvedor) {
        if (desenvolvedor != null) {
            desenvolvedores.add(desenvolvedor);
            System.out.println("Desenvolvedor " + desenvolvedor.getNome() + " adicionado à loja.");
        }
    }

    public void adicionarProduto(Produto produto) {
        if (produto != null) {
            produtos.add(produto);
            System.out.println("Produto " + produto.getNome() + " adicionado à loja.");
        }
    }

    public void removerProduto(Produto produto) {
        if (produtos.remove(produto)) {
            System.out.println("Produto " + produto.getNome() + " removido da loja.");
        } else {
            System.out.println("Produto não encontrado na loja.");
        }
    }

    // Novo método para adicionar uma assinatura
    public void adicionarAssinatura(Assinatura assinatura) {
        if (assinatura != null) {
            assinaturas.add(assinatura);
            System.out.println("Assinatura do tipo " + assinatura.getTipo() + " adicionada.");
        }
    }

    // Novo método para listar assinaturas
    public List<Assinatura> listarAssinaturas() {
        return new ArrayList<>(assinaturas);
    }

    public List<Produto> mostrarProdutosDisponiveis(String categoria, boolean porPopularidade, boolean porAvaliacao) {
        List<Produto> resultado = categoria == null
                ? new ArrayList<>(produtos)
                : produtos.stream()
                    .filter(produto -> produto.getCategoria().equalsIgnoreCase(categoria))
                    .collect(Collectors.toList());

        if (porPopularidade) {
            resultado.sort((prod1, prod2) -> {
                if (prod1 instanceof Aplicativo && prod2 instanceof Aplicativo) {
                    return Integer.compare(((Aplicativo) prod2).getDownloads(), ((Aplicativo) prod1).getDownloads());
                }
                return 0;
            });
        }

        if (porAvaliacao) {
            resultado.sort((prod1, prod2) -> Double.compare(prod2.getAvaliacaoMedia(), prod1.getAvaliacaoMedia()));
        }

        for (Produto prod : resultado) {
            System.out.println(prod.getNome() + " - Categoria: " + prod.getCategoria());
        }
        return resultado;
    }

    public List<Aplicativo> getAplicativosDisponiveis() {
        return produtos.stream()
                .filter(produto -> produto instanceof Aplicativo)
                .map(produto -> (Aplicativo) produto)
                .collect(Collectors.toList());
    }
}
