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

    public boolean getNavioPosicionado() {
        return navioPosicionado;
    }

    public boolean getTiro() {
        return tiro;
    }

    public boolean getTiroCerteiro() {
        return tiroCerteiro;
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
