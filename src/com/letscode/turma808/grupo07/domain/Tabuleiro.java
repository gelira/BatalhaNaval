package com.letscode.turma808.grupo07.domain;

import java.util.Random;

public class Tabuleiro {
    public static final int QUANTIDADE_NAVIOS = 10;
    public static final String LINHAS = "ABCDEFGHIJ";
    public static final String COLUNAS = "0123456789";

    private PosicaoTabuleiro[][] posicoes;
    private String nomeJogador;
    private int quantidadeNaviosRestantes;

    public Tabuleiro(String nomeJogador) {
        this.nomeJogador = nomeJogador;
        quantidadeNaviosRestantes = 0;

        posicoes = new PosicaoTabuleiro[LINHAS.length()][COLUNAS.length()];

        for (int i = 0; i < LINHAS.length(); i ++) {
            for (int j = 0; j < COLUNAS.length(); j ++) {
                posicoes[i][j] = new PosicaoTabuleiro();
            }
        }
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public int getQuantidadeNaviosRestantes() {
        return quantidadeNaviosRestantes;
    }

    public PosicaoTabuleiro[][] getPosicoes() {
        return posicoes;
    }

    public PosicaoTabuleiro getPosicao() {
        Random r = new Random();
        return getPosicao(r.nextInt(LINHAS.length()), r.nextInt(COLUNAS.length()));
    }

    public PosicaoTabuleiro getPosicao(String linha, String coluna) {
        return getPosicao(LINHAS.indexOf(linha), COLUNAS.indexOf(coluna));
    }

    private PosicaoTabuleiro getPosicao(int linhaIndex, int colunaIndex) {
        if (linhaIndex < 0 || colunaIndex < 0) {
            return null;
        }

        return posicoes[linhaIndex][colunaIndex];
    }

    public void setQuantidadeNaviosRestantes(int quantidadeNaviosRestantes) {
        this.quantidadeNaviosRestantes = quantidadeNaviosRestantes;
    }
}
