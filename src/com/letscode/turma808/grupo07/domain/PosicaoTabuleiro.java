package com.letscode.turma808.grupo07.domain;

public class PosicaoTabuleiro {
    private boolean navioPosicionado;
    private boolean tiro;
    private boolean tiroCerteiro;
    private int linha;
    private int coluna;

    public PosicaoTabuleiro(int linha, int coluna) {
        navioPosicionado = false;
        tiro = false;
        tiroCerteiro = false;

        this.linha = linha;
        this.coluna = coluna;
    }

    public boolean getNavioPosicionado() {
        return navioPosicionado;
    }

    public boolean getTiro() {
        return tiro;
    }

    public boolean getTiroCerteiro() {
        return tiroCerteiro;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setNavioPosicionado(boolean navioPosicionado) {
        this.navioPosicionado = navioPosicionado;
    }

    public void setTiro(boolean tiro) {
        this.tiro = tiro;
    }

    public void setTiroCerteiro(boolean tiroCerteiro) {
        this.tiroCerteiro = tiroCerteiro;
    }
}
