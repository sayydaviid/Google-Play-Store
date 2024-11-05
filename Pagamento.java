public class Pagamento {
  private double valor;
  private Usuario usuario;
  private String metodoPagamento;
  private String status;

  public Pagamento(double valor, Usuario usuario, String metodoPagamento) {
      this.valor = valor;
      this.usuario = usuario;
      this.metodoPagamento = metodoPagamento;
      this.status = "Pendente";
  }

  public boolean processarPagamento() {
      if (verificarFundos()) {
          status = "Aprovado";
          System.out.println("Pagamento de R$" + valor + " aprovado para " + usuario.getNome() + " usando " + metodoPagamento);
          return true;
      } else {
          status = "Negado";
          System.out.println("Pagamento de R$" + valor + " negado.");
          return false;
      }
  }

  public boolean reembolsar() {
      if (status.equals("Aprovado")) {
          status = "Reembolsado";
          System.out.println("Reembolso de R$" + valor + " realizado para " + usuario.getNome());
          return true;
      } else {
          System.out.println("Reembolso não pode ser realizado.");
          return false;
      }
  }

  private boolean verificarFundos() {
      return Math.random() > 0.2;
  }

  public String getMetodoPagamento() {
      return metodoPagamento;
  }

  public String getStatus() {
      return status;
  }

  public Usuario getUsuario() {
      return usuario;
  }
}
