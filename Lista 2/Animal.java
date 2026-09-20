import java.util.ArrayList; 

public class Animal{

    private long id;
    private String nome;
    private int idade;
    private double peso;
    private ArrayList<String> habilidades;

    public Animal(long id, String nome, int idade, double peso){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.habilidades = new ArrayList<>();
    }

    public String emitirSom() {
        return "som desconhecido";
    }  

    public String realizarHabilidade(String habilidade) {
        for (String h: habilidades) {
            if (h.equalsIgnoreCase(habilidade)) {
                return nome + " consegue " + habilidade;
            }
        }
        return nome + " não consegue " + habilidade;     
    }

    public long getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public double getPeso(){
        return this.peso;
    }

    public ArrayList<String> getHabilidades(){
        return this.habilidades;
    }
}