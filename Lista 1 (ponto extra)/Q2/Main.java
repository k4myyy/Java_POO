public class Main {

    public static void main (String [] args) {
        Autor autor1 = new Autor("George Orwell", "Britânico");
        Livro livro1 = new Livro("1984", 1949, autor1);

        Autor autor2 = new Autor("Machado de Assis", "Brasileiro");
        Livro livro2 = new Livro("Dom Casmurro", 1899, autor2);

        System.out.println(livro1);
        System.out.println(livro2);
    }
}