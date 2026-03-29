package model;

public class Carta {

    private String titulo;
    private String remetente;
    private String destinatario;
    private String mensagem;
    private String rodape;
    private String cor;

    public Carta(String titulo, String remetente, String destinatario, String mensagem, String rodape, String cor) {
        this.titulo = titulo;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
        this.rodape = rodape;
        this.cor = cor;
    }

    // getters e setters
    public String getTitulo() { return titulo; }
    public String getRemetente() { return remetente; }
    public String getDestinatario() { return destinatario; }
    public String getMensagem() { return mensagem; }
    public String getRodape() { return rodape; }

    public void exibir() {

        System.out.println(cor + "╔══════════════════════════════════════╗");
        System.out.printf("║ %-36s ║%n", titulo.toUpperCase());
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ De: %-33s ║%n", remetente);
        System.out.printf("║ Para: %-30s ║%n", destinatario);
        System.out.println("╠══════════════════════════════════════╣");

        quebrarTexto(mensagem);

        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ %-36s ║%n", rodape);
        System.out.println("╚══════════════════════════════════════╝" + util.Cores.RESET);
    }

    private void quebrarTexto(String texto) {
        int largura = 36;

        while (texto.length() > largura) {
            System.out.printf("║ %-36s ║%n", texto.substring(0, largura));
            texto = texto.substring(largura);
        }
        System.out.printf("║ %-36s ║%n", texto);
    }
}