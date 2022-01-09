package com.letscode.turma808.grupo07.domain;

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
}
