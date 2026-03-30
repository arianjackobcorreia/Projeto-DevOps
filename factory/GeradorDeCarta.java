package factory;

import model.*;

public class GeradorDeCarta {

    public static Carta criarCarta(TiposCarta tipo, String remetente, String destinatario, String cor) {

        switch (tipo) {

            case FINANCEIRO:
                return new Carta("*-* Financeiro *-*", remetente,
                        destinatario,
                        "Seu saldo está sob controle.\nContinue assim.",
                        "💰 Sistema Financeiro.", cor);

            case AMOR:
                return new Carta("--* Amor *--", remetente,
                        destinatario,
                        "No meio do caos,\nfoi você quem fez sentido.",
                        "❤️", cor);

            case MOTIVACAO:
                return new Carta("*-- Motivação --*", remetente,
                        destinatario,
                        "Você já sobreviveu a dias piores.\nContinua!",
                        "🚀", cor);

            case DESCULPAS:
                return new Carta("Desculpas!", remetente,
                        destinatario,
                        "Eu errei.\nMas estou tentando melhorar.",
                        "Com sinceridade. Irei te provar!", cor);

            case PARABENS:
                return new Carta("Parabéns!", remetente,
                        destinatario,
                        "Você conseguiu.\nE isso é só o começo.",
                        "🎉", cor);

            case AVISO:
                return new Carta("Aviso!", remetente,
                        destinatario,
                        "Algo precisa da sua atenção.\nFique alerta.",
                        "⚠️", cor);

            case REFLEXAO:
                return new Carta("* Reflexão... *", remetente,
                        destinatario,
                        "Nem tudo precisa ser entendido agora.\nSó sentido.",
                        "🧠", cor);

            case PERSEVERANCA:
                return new Carta("Perseverança", remetente,
                        destinatario,
                        "Ninguém vai fazer por você.\nNão desista!\nLevanta e faz.",
                        "🔥", cor);

            case DESPEDIDA:
                return new Carta("Despedida", remetente,
                        destinatario,
                        "Alguns ciclos acabam.\nE tudo bem.",
                        "Adeus! 👋", cor);

            case POETICA:
                return new Carta("Poética", remetente,
                        destinatario,
                        "Você é verso solto\nnum mundo de linhas retas.",
                        "🌙", cor);

            default:
                return new
                        Carta("Padrão", remetente, destinatario,
                        "Mensagem Padrão.",
                        "...", cor);
        }
    }
}