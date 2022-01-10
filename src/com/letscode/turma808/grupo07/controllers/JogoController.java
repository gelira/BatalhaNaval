package com.letscode.turma808.grupo07.controllers;

public class JogoController {
    private TabuleiroController tabuleiroJogador;
    private TabuleiroController tabuleiroComputador;

    public JogoController() {
        tabuleiroJogador = new TabuleiroController();
        tabuleiroComputador = new TabuleiroController("COMPUTADOR");
    }

    public void posicionarNavios() {
        tabuleiroJogador.definirPosicoesNavios();
        tabuleiroComputador.definirPosicoesNaviosAleatoriamente();
    }


}
