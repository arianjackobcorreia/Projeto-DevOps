package service;

import factory.GeradorDeCarta;
import model.Carta;

public class CartaService {

    public Carta gerarCarta(int tipo, String nome) {
        return GeradorDeCarta.criarCarta(tipo, nome);
    }
}