public class Review {
  private Usuario usuario;
  private Aplicativo aplicativo;
  private String comentario;
  private int nota;

  public Review(Usuario usuario, Aplicativo aplicativo, String comentario, int nota) {
      this.usuario = usuario;
      this.aplicativo = aplicativo;
      this.comentario = comentario;
      this.nota = nota;
  }

  public int getNota() {
      return nota;
  }

  public Usuario getUsuario() {
      return usuario;
  }

  public Aplicativo getAplicativo() {
      return aplicativo;
  }

  public String getComentario() {
      return comentario;
  }
}
