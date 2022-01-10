package com.letscode.turma808.grupo07.domain;

import java.util.Random;

public class Tabuleiro {
    public static final int QUANTIDADE_NAVIOS = 10;
    public static final String LINHAS = "ABCDEFGHIJ";
    public static final String COLUNAS = "0123456789";

    private PosicaoTabuleiro[][] posicoes;
    private String nomeJogador;
    private int quantidadeNaviosRestantes;
    private int quantidadeTirosCertos;

    public Tabuleiro(String nomeJogador) {
        this.nomeJogador = nomeJogador;
        quantidadeNaviosRestantes = 0;
        quantidadeTirosCertos = 0;

        posicoes = new PosicaoTabuleiro[LINHAS.length()][COLUNAS.length()];

        for (int linha = 0; linha < LINHAS.length(); linha ++) {
            for (int coluna = 0; coluna < COLUNAS.length(); coluna ++) {
                posicoes[linha][coluna] = new PosicaoTabuleiro(linha, coluna);
            }
        }
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public int getQuantidadeNaviosRestantes() {
        return quantidadeNaviosRestantes;
    }

    public int getQuantidadeTirosCertos() {
        return quantidadeTirosCertos;
    }

    public PosicaoTabuleiro[][] getPosicoes() {
        return posicoes;
    }

    public void incQuantidadeNaviosRestantes() {
        quantidadeNaviosRestantes ++;
    }

    public void decQuantidadeNaviosRestantes() {
        quantidadeNaviosRestantes --;
    }

    public void incQuantidadeTirosCertos() {
        quantidadeTirosCertos ++;
    }
}
