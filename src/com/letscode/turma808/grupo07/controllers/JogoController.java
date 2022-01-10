package com.letscode.turma808.grupo07.controllers;

public class JogoController {
    private TabuleiroController tabuleiroHumano;
    private TabuleiroController tabuleiroComputador;

    public JogoController() {
        tabuleiroHumano = new TabuleiroController();
        tabuleiroComputador = new TabuleiroController("COMPUTADOR");
    }

    public void posicionarNavios() {
        tabuleiroHumano.definirPosicoesNavios();
        tabuleiroComputador.definirPosicoesNaviosAleatoriamente();
    }


}
