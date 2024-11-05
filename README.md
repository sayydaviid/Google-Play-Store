# Loja de Aplicativos - Simulação em Java

Este projeto simula uma loja de aplicativos em Java, onde usuários podem baixar aplicativos, escrever avaliações, assinar planos e realizar pagamentos. Desenvolvedores podem publicar aplicativos, e superusuários têm funções administrativas, como aprovar aplicativos e monitorar atividades.

## Funcionalidades

1. **Gerenciamento de Usuários**
   - **Usuário**: Pode baixar aplicativos, escrever avaliações e assinar planos.
   - **Desenvolvedor**: Pode publicar aplicativos e consultar relatórios de vendas.
   - **Superusuário**: Tem permissões adicionais para aprovar aplicativos e monitorar atividades de usuários.

2. **Gestão de Aplicativos**
   - Aplicativos podem ser publicados por desenvolvedores e baixados por usuários.
   - Usuários podem escrever avaliações, e a média de avaliação dos aplicativos é atualizada automaticamente.

3. **Assinaturas e Pagamentos**
   - Usuários podem assinar planos oferecidos na loja.
   - Simulação de processo de pagamento com opção de reembolso.

4. **Sistema de Reviews**
   - Usuários podem escrever reviews para aplicativos, com notas e comentários.
   - A loja exibe a lista de produtos organizados por categoria, popularidade e avaliação.

## Estrutura do Projeto

### Classes Principais

- **Loja**: Classe principal que gerencia os produtos, assinaturas, usuários e desenvolvedores.
- **UsuarioBase**: Classe abstrata para gerenciamento básico de usuários, incluindo login.
- **Usuario**: Representa um usuário comum, com permissões para baixar, avaliar e assinar aplicativos.
- **Desenvolvedor**: Usuário especial que pode publicar aplicativos e ver relatórios de vendas.
- **SuperUsuario**: Usuário com permissões de administrador para aprovar aplicativos e monitorar atividades.
- **Aplicativo**: Produto baixável que pode ser avaliado por usuários.
- **Assinatura**: Representa um plano de assinatura que os usuários podem adquirir.
- **Pagamento**: Simula uma transação de pagamento com verificação de fundos e opção de reembolso.
- **Review**: Representa uma avaliação feita por um usuário sobre um aplicativo.

### Interface

- **Baixavel**: Interface para objetos que podem ser baixados e abertos.

## Exemplo de Uso

O arquivo `Main` contém um exemplo de execução que testa todas as funcionalidades principais:

```java
public class Main {
    public static void main(String[] args) {
        // Criação da loja e dos usuários
        Loja loja = new Loja();
        Usuario usuario1 = new Usuario("Carlos Silva", "carlos@email.com", "senha123");
        Desenvolvedor dev1 = new Desenvolvedor("Ana Desenvolvedora", "ana@dev.com", "devsenha");
        SuperUsuario superUser = new SuperUsuario("João Admin", "admin@loja.com", "admin123");

        // Login dos usuários
        usuario1.fazerLogin("senha123");
        superUser.fazerLogin("admin123");

        // Publicação de um aplicativo pelo desenvolvedor
        Aplicativo app1 = new Aplicativo("Calculadora", 15.2, "Ana Desenvolvedora", "Ferramentas");
        dev1.publicarApp(app1);
        loja.adicionarProduto(app1);

        // Usuário assina plano, baixa e avalia o aplicativo
        Assinatura assinatura1 = new Assinatura("Premium", 29.99, usuario1);
        usuario1.assinar(assinatura1);
        usuario1.baixarAplicativo(app1);
        usuario1.escreverReview(app1, "Excelente aplicativo!", 5);

        // Exibir produtos disponíveis e processar um pagamento
        loja.mostrarProdutosDisponiveis("Ferramentas", true, true);
        Pagamento pagamento1 = new Pagamento(49.99, usuario1, "Cartão de Crédito");
        pagamento1.processarPagamento();
    }
}
