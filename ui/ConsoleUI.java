package ui;

import model.Carta;
import service.CartaService;
import repository.RepositoryCarta;

import java.util.*;

public class ConsoleUI {

    private Scanner sc = new Scanner(System.in);
    private CartaService service = new CartaService();
    private RepositoryCarta repo = new RepositoryCarta();

    private List<Carta> historico = new ArrayList<>();

    public void iniciar() {

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Gerar carta");
            System.out.println("2 - Criar carta personalizada");
            System.out.println("3 - Ver histórico (memória)");
            System.out.println("4 - Ver histórico (arquivo)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    gerarCarta(nome);
                    break;

                case 2:
                    criarCarta(nome);
                    break;

                case 3:
                    mostrarHistorico();
                    break;

                case 4:
                    repo.lerHistorico();
                    break;

                case 0:
                    System.out.println("\nObrigado por sua visita. Tchau! 👋");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void gerarCarta(String nome) {

        System.out.println("\u001B[32mGerando sua carta...\u001B[0m\n");

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " - Tipo " + i);
        }

        System.out.print("Escolha: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        Carta carta = service.gerarCarta(tipo, nome);

        carta.exibir();

        historico.add(carta);
        repo.salvar(carta);
    }

    private void criarCarta(String nome) {

        System.out.println("\nCriando nova carta...\n");

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Mensagem: ");
        String mensagem = sc.nextLine();

        System.out.print("Rodapé: ");
        String rodape = sc.nextLine();

        Carta carta = new Carta(titulo, nome, mensagem, rodape);

        carta.exibir();

        historico.add(carta);
        repo.salvar(carta);
    }

    private void mostrarHistorico() {

        if (historico.isEmpty()) {
            System.out.println("Nenhuma carta ainda.");
            return;
        }

        for (Carta c : historico) {
            c.exibir();
        }
    }
}