public class Main {
    public static void main(String[] args) {
        // Criação de loja
        Loja loja = new Loja();

        // Criação de usuários
        Usuario usuario1 = new Usuario("Carlos Silva", "carlos@email.com", "senha123");
        Desenvolvedor dev1 = new Desenvolvedor("Ana Desenvolvedora", "ana@dev.com", "devsenha");
        SuperUsuario superUser = new SuperUsuario("João Admin", "admin@loja.com", "admin123");

        // Adição de usuários na loja
        loja.adicionarUsuario(usuario1);
        loja.adicionarDesenvolvedor(dev1);

        // Login de usuário e super usuário
        usuario1.fazerLogin("senha123");
        superUser.fazerLogin("admin123");

        // Criação de aplicativo e publicação
        Aplicativo app1 = new Aplicativo("Calculadora", 15.2, "Ana Desenvolvedora", "Ferramentas");
        dev1.publicarApp(app1);
        loja.adicionarProduto(app1);

        // Criação de assinatura
        Assinatura assinatura1 = new Assinatura("Premium", 29.99, usuario1);
        loja.adicionarAssinatura(assinatura1);

        // Assinatura do usuário e checagem de status
        usuario1.assinar(assinatura1);
        System.out.println("Status da assinatura: " + assinatura1.checarStatus());

        // Baixar aplicativo e abrir
        usuario1.baixarAplicativo(app1);
        app1.abrir();

        // Usuário escrevendo review
        usuario1.escreverReview(app1, "Excelente aplicativo!", 5);

        // Mostrando produtos disponíveis na loja
        loja.mostrarProdutosDisponiveis("Ferramentas", true, true);

        // Super usuário aprovando aplicativo e monitorando atividades
        superUser.aprovarApp(app1);
        superUser.adicionarAtividadeMonitorada("Aprovação de app");
        superUser.visualizarAtividades();

        // Processo de pagamento
        Pagamento pagamento1 = new Pagamento(49.99, usuario1, "Cartão de Crédito");
        pagamento1.processarPagamento();

        // Tentativa de reembolso do pagamento
        pagamento1.reembolsar();

        // Desenvolvedor consultando relatórios de vendas
        dev1.consultarRelatoriosVendas();

        // Listar assinaturas da loja
        System.out.println("Assinaturas disponíveis na loja:");
        for (Assinatura assinatura : loja.listarAssinaturas()) {
            System.out.println("- Tipo: " + assinatura.getTipo() + ", Valor: R$" + assinatura.getValor());
        }
    }
}
