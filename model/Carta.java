package model;

public class Carta {
    private String titulo;
    private String destinatario;
    private String mensagem;
    private String rodape;

    public Carta(String titulo, String destinatario, String mensagem, String rodape) {
        this.titulo = titulo;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
        this.rodape = rodape;
    }

    public void exibir() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.printf("║ %-36s ║%n", titulo.toUpperCase());
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ Para: %-30s ║%n", destinatario);
        System.out.println("╠══════════════════════════════════════╣");

        for (String linha : mensagem.split("\n")) {
            System.out.printf("║ %-36s ║%n", linha);
        }

        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ %-36s ║%n", rodape);
        System.out.println("╚══════════════════════════════════════╝");
    }
}
