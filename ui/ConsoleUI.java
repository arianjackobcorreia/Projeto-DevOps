package ui;

import java.util.Scanner;
import model.Carta;
import service.CartaService;

public class ConsoleUI {

    private Scanner sc = new Scanner(System.in);
    private CartaService service = new CartaService();

    public void iniciar() {

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("\nEscolha o tipo de carta:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " - Tipo " + i);
        }

        System.out.print("Opção: ");
        int tipo = sc.nextInt();

        Carta carta = service.gerarCarta(tipo, nome);

        System.out.println();
        carta.exibir();
    }
}