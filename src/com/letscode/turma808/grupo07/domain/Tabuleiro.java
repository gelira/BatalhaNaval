package com.letscode.turma808.grupo07.domain;

public class Tabuleiro {
    private final int QUANTIDADE_NAVIOS = 10;
    private final String LINHAS = "ABCDEFGHIJ";
    private final String COLUNAS = "0123456789";

    private PosicaoTabuleiro[][] posicoes;
    private String nomeJogador;
    private int quantidadeNaviosRestantes;

    public Tabuleiro(String nomeJogador) {
        this.nomeJogador = nomeJogador;
        quantidadeNaviosRestantes = 10;

        posicoes = new PosicaoTabuleiro[LINHAS.length()][COLUNAS.length()];

        for (int i = 0; i < LINHAS.length(); i ++) {
            for (int j = 0; j < COLUNAS.length(); j ++) {
                posicoes[i][j] = new PosicaoTabuleiro();
            }
        }
    }

    public int getQUANTIDADE_NAVIOS() {
        return QUANTIDADE_NAVIOS;
    }

    public PosicaoTabuleiro[][] getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(PosicaoTabuleiro[][] posicoes) {
        this.posicoes = posicoes;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getQuantidadeNaviosRestantes() {
        return quantidadeNaviosRestantes;
    }

    public void setQuantidadeNaviosRestantes(int quantidadeNaviosRestantes) {
        this.quantidadeNaviosRestantes = quantidadeNaviosRestantes;
    }
}
