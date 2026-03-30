package repository;

import model.Carta;

import java.io.*;

public class RepositoryCarta {

    private static final String ARQUIVO = "cartas.txt";

    public void salvar(Carta carta) {
        try (FileWriter writer = new FileWriter(ARQUIVO, true)) {

            writer.write("====*= CARTA =*====\n");
            writer.write("Titulo: " + carta.getTitulo() + "\n");
            writer.write("Para: " + carta.getDestinatario() + "\n");
            writer.write(carta.getMensagem() + "\n");
            writer.write(carta.getRodape() + "\n");
            writer.write("-------------------------\n");

        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo.");
        }
    }

    public void lerHistorico() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {

            String linha;
            System.out.println("\n=====* HISTÓRICO *=====");

            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.out.println("Nenhum histórico encontrado.");
        }
    }
}