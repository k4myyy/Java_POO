public class Livro {
    String titulo;
    int anoPublicacao;
    Autor autor;

    Livro (String titulo, int anoPublicacao, Autor autor) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Ano de publicação: " + anoPublicacao + ", Autor: " + autor;
    }
}