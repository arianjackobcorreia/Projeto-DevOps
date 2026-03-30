package ui;

import factory.GeradorDeCarta;
import model.Carta;
import model.TiposCarta;
import service.CartaService;
import repository.RepositoryCarta;
import util.Cores;

import java.util.*;

public class ConsoleUI {

    private Scanner sc = new Scanner(System.in);
    private CartaService service = new CartaService();
    private RepositoryCarta repo = new RepositoryCarta();

    private List<Carta> historico = new ArrayList<>();

    public void iniciar() {

        System.out.println("=====* CADASTRO *=====");
        System.out.print("Digite seu nome (remetente): ");
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
                    System.out.println("\nObrigado por usar os nossos serviços. Tchau!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private int totalCartas = 0;

    private void gerarCarta(String remetente) {

        if (totalCartas >= 15) {
            System.out.println("Limite de cartas atingido!");
            return;
        }

        System.out.print("Possui destinatário? (s/n): ");
        String escolha = sc.nextLine();

        String destinatario = remetente;

        if (escolha.equalsIgnoreCase("s")) {
            System.out.print("Digite o nome do destinatário: ");
            destinatario = sc.nextLine();
        }

        System.out.println("\nEscolha o tipo:");
        for (TiposCarta t : TiposCarta.values()) {
            System.out.println(t.getCodigo() + " - " + t.getDescricao());
        }

        int tipoInput = sc.nextInt();
        sc.nextLine();

        TiposCarta tipo = TiposCarta.fromCodigo(tipoInput);

        if (tipo == null) {
            System.out.println("Tipo inválido!");
            return;
        }

        System.out.println("Escolha a cor:");
        System.out.println("1 - Azul\n2 - Verde\n3 - Vermelho\n4 - Amarelo");

        int corInput = sc.nextInt();
        sc.nextLine();

        String cor = util.Cores.RESET;

        switch (corInput) {
            case 1: cor = util.Cores.AZUL; break;
            case 2: cor = util.Cores.VERDE; break;
            case 3: cor = util.Cores.VERMELHO; break;
            case 4: cor = Cores.AMARELO; break;
        }

        System.out.print("Deseja cancelar a carta? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.println("Operação cancelada.");
            return;
        }

        System.out.println("Gerando sua carta...\n");

        Carta carta = service.gerarCarta(tipo, remetente, destinatario, cor);

        carta.exibir();
        historico.add(carta);
        repo.salvar(carta);

        totalCartas++;
    }

    private void criarCarta(String remetente) {

        System.out.println("\nCriando nova carta...\n");

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Destinatário:");
        String destinatario = sc.nextLine();

        System.out.print("Mensagem: ");
        String mensagem = sc.nextLine();

        System.out.print("Rodapé: ");
        String rodape = sc.nextLine();

        String cor = Cores.RESET;

        Carta carta = new Carta(
                titulo,
                remetente,
                destinatario,
                mensagem,
                rodape,
                cor
        );

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