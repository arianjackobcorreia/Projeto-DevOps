package service;

import factory.GeradorDeCarta;
import model.Carta;
import model.TiposCarta;

public class CartaService {

    public Carta gerarCarta(TiposCarta tipo, String remetente, String destinatario, String cor) {

        if (tipo == null) {
            throw new IllegalArgumentException("Tipo inválido");
        }
        return GeradorDeCarta.criarCarta(tipo, remetente, destinatario, cor);
    }

}