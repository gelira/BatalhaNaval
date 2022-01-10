package com.letscode.turma808.grupo07.controllers;

import com.letscode.turma808.grupo07.domain.PosicaoTabuleiro;
import com.letscode.turma808.grupo07.views.JogadaView;
import com.letscode.turma808.grupo07.views.UtilView;

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

    public void jogar() {
        posicionarNavios();

        while (true) {
            UtilView.clearScreen();
            tabuleiroHumano.showTabuleiro();
            // tabuleiroComputador.showTabuleiro();

            jogadaHumano();
            if (tabuleiroComputador.avaliarVitoriaOponente()) {
                tabuleiroHumano.showVitoria();
                break;
            }

            jogadaComputador();
            if (tabuleiroHumano.avaliarVitoriaOponente()) {
                tabuleiroComputador.showVitoria();
                break;
            }
        }

        tabuleiroHumano.showTabuleiro();
        tabuleiroComputador.showTabuleiro();
    }

    private void jogadaHumano() {
        Integer[] posicaoJogada;
        Integer linha;
        Integer coluna;

        while (true) {
            posicaoJogada = JogadaView.askPosicao();
            if (posicaoJogada == null) {
                JogadaView.showPosicaoInvalida();
                continue;
            }

            linha = posicaoJogada[0];
            coluna = posicaoJogada[1];

            if (linha == null || coluna == null) {
                JogadaView.showPosicaoInvalida();
                continue;
            }

            PosicaoTabuleiro posicao = tabuleiroHumano.getPosicao(linha, coluna);

            if (posicao.getTiro()) {
                JogadaView.showTiroAnterior();
                continue;
            }

            jogada(tabuleiroComputador, posicao);
            break;
        }
    }

    private void jogadaComputador() {
        PosicaoTabuleiro posicao;

        do {
            posicao = tabuleiroComputador.getPosicao();
        } while (posicao.getTiro());

        jogada(tabuleiroHumano, posicao);
    }

    private void jogada(TabuleiroController tabuleiroOponente, PosicaoTabuleiro posicao) {
        posicao.setTiro(true);

        if (tabuleiroOponente.avaliarTiroCerteiro(posicao.getLinha(), posicao.getColuna())) {
            posicao.setTiroCerteiro(true);
        }
    }
}
