package com.letscode.turma808.grupo07.views;

import com.letscode.turma808.grupo07.domain.PosicaoTabuleiro;
import com.letscode.turma808.grupo07.domain.Tabuleiro;

public class TabuleiroView {
    private static final int QUANTIDADE_CARACTERES_LINHA = 45;

    public static String tabuleiro[][]= new String[10][10];//cria um tabuleiro  10x10//
    public static void imprimeTabuleiro(){

        System.out.println("    0   1   2   3   4   5   6   7   8   9"); //numero da coluna
        System.out.println("  _________________________________________");
        for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 9//
            System.out.print(l + " ");   //numero da linhas do lado do tabuleiro
            for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 9//
                System.out.print("| "+tabuleiro[l][c]+" ");
            }
            System.out.println("|");
            System.out.println("  _________________________________________");
        }
    }

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

    public static void inicilizaMatriz(){
        for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 9//
            for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 9//
                tabuleiro[l][c]=" ";
            }
        }
    }

    public static void posicionaNaviosTabuleiro(String[][] posicao){
        for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 9//
            for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 9//
                if(posicao[l][c] != null)
                    tabuleiro[l][c]=posicao[l][c];
            }
        }
    }

}
