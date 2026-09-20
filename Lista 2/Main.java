import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();
        int opcao;

        do {
            exibirMenu();
            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    adicionarAnimal(zoologico);
                    break;
                case 2:
                    listarAnimais(zoologico);
                    break;
                case 3:
                    removerAnimal(zoologico);
                    break;
                case 4:
                    emitirSom(zoologico);
                    break;
                case 5:
                    testarHabilidade(zoologico);
                    break;
                case 6:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("ZOOLÓGICO");
        System.out.println("1. Adicionar animal");
        System.out.println("2. Listar todos os animais");
        System.out.println("3. Remover animal");
        System.out.println("4. Emitir som de um animal");
        System.out.println("5. Testar habilidade de um animal");
        System.out.println("6. Sair");
    }

    private static void adicionarAnimal(Zoologico zoologico) {
        System.out.println("Tipo do animal:");
        System.out.println("1. Gato");
        System.out.println("2. Cachorro");
        System.out.println("3. Passaro");
        int tipo = lerInt("Escolha o tipo: ");

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo inválido!");
            return; 
        }

        long id = lerLong("ID: ");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        int idade = lerInt("Idade: ");
        double peso = lerDouble("Peso: ");

        Animal animal;
        if (tipo == 1) {
            animal = new Gato(id, nome, idade, peso);
        } else if (tipo == 2) {
            animal = new Cachorro(id, nome, idade, peso);
        } else {
            animal = new Passaro(id, nome, idade, peso);
        }

        if (zoologico.adicionarAnimal(animal)) {
            System.out.println("Animal adicionado com sucesso!");
        } else {
            System.out.println("Já existe um animal com esse ID!");
        }
    }

    private static void listarAnimais(Zoologico zoologico) {
        if (zoologico.listarAnimais().isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return;
        }

        for (Animal animal : zoologico.listarAnimais()) {
            System.out.println("ID: " + animal.getId()
                    + " | Tipo: " + animal.getClass().getSimpleName()
                    + " | Nome: " + animal.getNome()
                    + " | Idade: " + animal.getIdade()
                    + " | Peso: " + animal.getPeso()
                    + " | Habilidades: " + animal.getHabilidades());
        }
    }

    private static void removerAnimal(Zoologico zoologico) {
        long id = lerLong("ID do animal a remover: ");
        boolean removido = zoologico.removerAnimal(id);
        System.out.println("Animal removido: " + removido);
    }

    private static void emitirSom(Zoologico zoologico) {
        long id = lerLong("ID do animal: ");
        Animal animal = zoologico.buscarAnimal(id);

        if (animal != null) {
            System.out.println(animal.getNome() + " diz " + animal.emitirSom());
        } else {
            System.out.println("Animal não encontrado.");
        }
    }

    private static void testarHabilidade(Zoologico zoologico) {
        long id = lerLong("ID do animal: ");
        Animal animal = zoologico.buscarAnimal(id);

        if (animal != null) {
            System.out.print("Habilidade: ");
            String habilidade = sc.nextLine();
            System.out.println(animal.realizarHabilidade(habilidade));
        } else {
            System.out.println("Animal não encontrado.");
        }
    }

    private static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static long lerLong(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Long.parseLong(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido (ex: 20.5).");
            }
        }
    }
}