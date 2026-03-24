package factory;

import model.Carta;

public class GeradorDeCarta {

    public static Carta criarCarta(int tipo, String nome) {

        switch (tipo) {

            case 1:
                return new Carta("** Financeiro **", nome,
                        "Seu saldo está sob controle.\nContinue assim.",
                        "💰 Sistema Financeiro.");

            case 2:
                return new Carta("--* Amor *--", nome,
                        "No meio do caos,\nfoi você quem fez sentido.",
                        "❤️");

            case 3:
                return new Carta("*-- Motivação --*", nome,
                        "Você já sobreviveu a dias piores.\nContinua.",
                        "🚀");

            case 4:
                return new Carta("Desculpas!", nome,
                        "Eu errei.\nMas estou tentando melhorar.",
                        "Com sinceridade. Irei te provar!");

            case 5:
                return new Carta("Parabéns!", nome,
                        "Você conseguiu.\nE isso é só o começo.",
                        "🎉");

            case 6:
                return new Carta("Aviso!", nome,
                        "Algo precisa da sua atenção.\nFique alerta.",
                        "⚠️");

            case 7:
                return new Carta("* Reflexão *", nome,
                        "Nem tudo precisa ser entendido agora.\nSó sentido.",
                        "🧠");

            case 8:
                return new Carta("Hardcore", nome,
                        "Ninguém vai fazer por você.\nLevanta e faz.",
                        "🔥");

            case 9:
                return new Carta("Despedida", nome,
                        "Alguns ciclos acabam.\nE tudo bem.",
                        "Tchau! 👋");

            case 10:
                return new Carta("Poética", nome,
                        "Você é verso solto\nnum mundo de linhas retas.",
                        "🌙");

            default:
                throw new IllegalArgumentException("Tipo inválido");
        }
    }
}