public abstract class UsuarioBase {
  private String nome;
  private String email;
  private String senha;
  private boolean logado;

  public UsuarioBase(String nome, String email, String senha) {
      this.nome = nome;
      this.email = email;
      this.senha = senha;
      this.logado = false;
  }

  public void fazerLogin(String senha) {
      if (this.senha.equals(senha)) {
          this.logado = true;
          System.out.println(nome + " logado com sucesso com o email: " + email);
      } else {
          System.out.println("Senha incorreta.");
      }
  }

  public abstract void escreverReview(Aplicativo app, String texto, int nota);

  public boolean isLogado() {
      return logado;
  }

  public String getNome() {
      return nome;
  }

  protected String getEmail() {
      return email;
  }

  protected String getSenha() {
      return senha;
  }

  protected void setNome(String nome) {
      this.nome = nome;
  }

  protected void setEmail(String email) {
      this.email = email;
  }

  protected void setSenha(String senha) {
      this.senha = senha;
  }

  protected void setLogado(boolean logado) {
      this.logado = logado;
  }
}
