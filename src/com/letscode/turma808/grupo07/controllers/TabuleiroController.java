package com.letscode.turma808.grupo07.controllers;

import com.letscode.turma808.grupo07.domain.PosicaoTabuleiro;
import com.letscode.turma808.grupo07.domain.Tabuleiro;
import com.letscode.turma808.grupo07.views.NomeJogadorView;
import com.letscode.turma808.grupo07.views.PosicionarNaviosView;
import com.letscode.turma808.grupo07.views.TabuleiroView;

import java.util.Random;

public class TabuleiroController {
    private Tabuleiro tabuleiro;

    public TabuleiroController() {
        String nome = NomeJogadorView.askNomeJogador();
        tabuleiro = new Tabuleiro(nome);
    }

    public TabuleiroController(String nomeJogador) {
        tabuleiro = new Tabuleiro(nomeJogador);
    }

    public PosicaoTabuleiro getPosicao() {
        Random r = new Random();
        return getPosicao(r.nextInt(Tabuleiro.LINHAS.length()), r.nextInt(Tabuleiro.COLUNAS.length()));
    }

    public PosicaoTabuleiro getPosicao(int linhaIndex, int colunaIndex) {
        PosicaoTabuleiro[][] posicoes = tabuleiro.getPosicoes();
        return posicoes[linhaIndex][colunaIndex];
    }


    public void definirPosicoesNavios() {
        PosicionarNaviosView.showDescricao();
        int posicoesRestantes;

        while (true) {
            posicoesRestantes = Tabuleiro.QUANTIDADE_NAVIOS - tabuleiro.getQuantidadeNaviosRestantes();
            if (posicoesRestantes == 0) {
                break;
            }

            Integer[] coordenada = PosicionarNaviosView.askPosicao(posicoesRestantes);
            if (coordenada == null) {
                PosicionarNaviosView.showMensagemPosicaoInvalida();
                continue;
            }

            Integer linha = coordenada[0];
            Integer coluna = coordenada[1];

            PosicaoTabuleiro posicao;

            if (linha == null || coluna == null) {
                do {
                    posicao = getPosicao();
                } while (posicao.getNavioPosicionado());
            }
            else {
                posicao = getPosicao(linha, coluna);

                if (posicao.getNavioPosicionado()) {
                    PosicionarNaviosView.showMensagemPosicaoInvalida();
                    continue;
                }
            }

            posicao.setNavioPosicionado(true);
            tabuleiro.incQuantidadeNaviosRestantes();
        }
    }

    public void definirPosicoesNaviosAleatoriamente() {
        PosicaoTabuleiro posicao;
        int posicoesRestantes;

        do {
            do {
                posicao = getPosicao();
            } while (posicao.getNavioPosicionado());

            posicao.setNavioPosicionado(true);
            tabuleiro.incQuantidadeNaviosRestantes();

            posicoesRestantes = Tabuleiro.QUANTIDADE_NAVIOS - tabuleiro.getQuantidadeNaviosRestantes();
        } while (posicoesRestantes > 0);
    }
    
    private PosicaoTabuleiro getPosicaoEscolhida(int linha, int coluna, Tabuleiro tabuleiro){

        PosicaoTabuleiro[][] posicoesDoTabuleiro = tabuleiro.getPosicoes();

        PosicaoTabuleiro posicaoEscolhida = posicoesDoTabuleiro[linha][coluna];

        return posicaoEscolhida;

    }

    public void showTabuleiro() {
        TabuleiroView.imprimeTabuleiro(tabuleiro);
    }

    public boolean avaliarTiroCerteiro(int linha, int coluna) {
        PosicaoTabuleiro posicaoAtirada = getPosicao(linha, coluna);

        if (posicaoAtirada.getNavioPosicionado()) {
            posicaoAtirada.setNavioPosicionado(false);
            tabuleiro.decQuantidadeNaviosRestantes();

            return true;
        }

        return false;
    }

    public boolean avaliarVitoriaOponente() {
        return tabuleiro.getQuantidadeNaviosRestantes() == 0;
    }

    public void showVitoria() {
        TabuleiroView.showVitoria(tabuleiro.getNomeJogador());
    }
}
