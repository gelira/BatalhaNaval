package com.letscode.turma808.grupo07.domain;

public class PosicaoTabuleiro {
    private boolean navioPosicionado;
    private boolean tiro;
    private boolean tiroCerteiro;

    public PosicaoTabuleiro() {
        navioPosicionado = false;
        tiro = false;
        tiroCerteiro = false;
    }

    public boolean isNavioPosicionado() {
        return navioPosicionado;
    }

    public void setNavioPosicionado(boolean navioPosicionado) {
        this.navioPosicionado = navioPosicionado;
    }

    public boolean isTiro() {
        return tiro;
    }

    public void setTiro(boolean tiro) {
        this.tiro = tiro;
    }

    public boolean isTiroCerteiro() {
        return tiroCerteiro;
    }

    public void setTiroCerteiro(boolean tiroCerteiro) {
        this.tiroCerteiro = tiroCerteiro;
    }
}
