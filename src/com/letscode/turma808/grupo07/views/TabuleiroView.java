package com.letscode.turma808.grupo07.views;

import com.letscode.turma808.grupo07.domain.PosicaoTabuleiro;
import com.letscode.turma808.grupo07.domain.Tabuleiro;

public class TabuleiroView {
    private static final int QUANTIDADE_CARACTERES_LINHA = 45;

    public static void imprimeTabuleiro(Tabuleiro tabuleiro) {
        imprimeLinhaTracejada();
        imprimeNomeJogador(tabuleiro.getNomeJogador());
        imprimeLinhaTracejada();
        imprimeCabecalhoColunas();
        imprimeLinhaTracejada();

        PosicaoTabuleiro[][] posicoes = tabuleiro.getPosicoes();

        for (int i = 0; i < posicoes.length; i ++) {
            imprimeLinhaTabuleiro(Tabuleiro.LINHAS.charAt(i), posicoes[i]);
            imprimeLinhaTracejada();
        }

        imprimeRodape(tabuleiro.getQuantidadeNaviosRestantes(), tabuleiro.getQuantidadeTirosCertos());
        imprimeLinhaTracejada();
    }

    private static void imprimeLinhaTracejada() {
        System.out.println("-".repeat(QUANTIDADE_CARACTERES_LINHA));
    }

    private static void imprimeNomeJogador(String nomeJogador) {
        String toPrint;
        int caracteresVazios = QUANTIDADE_CARACTERES_LINHA - nomeJogador.length();

        if (caracteresVazios > 0) {
            int caracteresVaziosDireita = caracteresVazios / 2;
            int caracteresVaziosEsquerda = caracteresVazios - caracteresVaziosDireita;

            toPrint = " ".repeat(caracteresVaziosEsquerda) + nomeJogador + " ".repeat(caracteresVaziosDireita);
        }
        else {
            toPrint = nomeJogador;
        }

        System.out.println(toPrint);
    }

    private static void imprimeCabecalhoColunas() {
        System.out.print("|   |");

        for (int i = 0; i < Tabuleiro.COLUNAS.length(); i ++) {
            System.out.printf(" %c |", Tabuleiro.COLUNAS.charAt(i));
        }

        System.out.println();
    }

    private static void imprimeRodape(int quantidadeNaviosRestantes, int quantidadeTirosCertos) {
        String naviosRestantes = String.format("Navios restantes: %2d", quantidadeNaviosRestantes);
        String tirosCertos = String.format("Tiros certos: %2d", quantidadeTirosCertos);

        int quantidadeCaracteresVazios = QUANTIDADE_CARACTERES_LINHA - naviosRestantes.length() - tirosCertos.length();

        System.out.println(naviosRestantes + " ".repeat(quantidadeCaracteresVazios) + tirosCertos);
    }

    private static void imprimeLinhaTabuleiro(char rotulo, PosicaoTabuleiro[] linha) {
        System.out.printf("| %c |", rotulo);

        for (PosicaoTabuleiro posicao : linha) {
            System.out.printf(" %c |", avaliarPosicao(posicao));
        }

        System.out.println();
    }

    private static char avaliarPosicao(PosicaoTabuleiro posicao) {
        char retorno = ' ';

        if (posicao.getNavioPosicionado()) {
            retorno = 'N';
            if (posicao.getTiro()) {
                retorno = posicao.getTiroCerteiro() ? 'X' : 'n';
            }
        }
        else {
            if (posicao.getTiro()) {
                retorno = posicao.getTiroCerteiro() ? '*' : '-';
            }
        }

        return retorno;
    }

    public static void showVitoria(String nomeJogador) {
        System.out.printf("%s GANHOU!!%n", nomeJogador);
    }
}
