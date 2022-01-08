package com.letscode.turma808.grupo07;

import com.letscode.turma808.grupo07.domain.Tabuleiro;
import com.letscode.turma808.grupo07.views.PosicionarNaviosView;
import com.letscode.turma808.grupo07.views.TabuleiroView;

public class Main {

    public static void main(String[] args) {
        TabuleiroView.inicilizaMatriz();
        TabuleiroView.imprimeTabuleiro();
        PosicionarNaviosView posicionar = new PosicionarNaviosView();
        TabuleiroView.posicionaNaviosTabuleiro(posicionar.posicionarNaviosAutomatico());
        TabuleiroView.imprimeTabuleiro();
    }
}
