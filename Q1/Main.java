public class Main {
    
    public static void main(String[] args) {
        Filme filme1 = new Filme("Interestelar", "Ficção Científica", 2014);
        Filme filme2 = new Filme("Toy Story", "Animação", 1995);

        System.out.println(filme1.titulo + "  " + filme1.genero + "  " + filme1.anoLancamento);
        System.out.println(filme2.titulo + "  " + filme2.genero + "  " + filme2.anoLancamento);
    }
}