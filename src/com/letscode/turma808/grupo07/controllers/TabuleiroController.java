package com.letscode.turma808.grupo07.controllers;

import com.letscode.turma808.grupo07.domain.PosicaoTabuleiro;
import com.letscode.turma808.grupo07.domain.Tabuleiro;

import javax.sound.midi.ControllerEventListener;
import java.util.Random;

public class TabuleiroController {

    private Tabuleiro tabuleiroJogador;

    private Tabuleiro tabuleiroInimigo;


    public TabuleiroController(Tabuleiro tabuleiroJogador, Tabuleiro tabuleiroInimigo) {
        this.tabuleiroJogador = tabuleiroJogador;
        this.tabuleiroInimigo = tabuleiroInimigo;
    }

    private PosicaoTabuleiro getPosicaoEscolhida(int linha, int coluna, Tabuleiro tabuleiro){

        PosicaoTabuleiro[][] posicoesDoTabuleiro = tabuleiro.getPosicoes();

        PosicaoTabuleiro posicaoEscolhida = posicoesDoTabuleiro[linha][coluna];

        return posicaoEscolhida;

    }

    private boolean isTiroCerteiro(PosicaoTabuleiro posicaoEscolhida,Tabuleiro tabuleiro){

        if(!posicaoEscolhida.isTiroCerteiro()){

            if(posicaoEscolhida.isNavioPosicionado()){

                posicaoEscolhida.setTiroCerteiro(true);
                posicaoEscolhida.setTiro(true);
                int naviosRestantes = tabuleiro.getQuantidadeNaviosRestantes() -1;
                tabuleiro.setQuantidadeNaviosRestantes(naviosRestantes);
                return true;

            }

        }

        return false;

    }

    public char[][] getPosicoesTabuleiro(boolean isJogador){

        PosicaoTabuleiro[][] posicoesTabuleiro;
        if(isJogador){
            posicoesTabuleiro =  this.tabuleiroJogador.getPosicoes();
        }else{
            posicoesTabuleiro =  this.tabuleiroInimigo.getPosicoes();
        }

        int tamanhoMatriz = posicoesTabuleiro.length;

        char[][] posicoesString = new char[tamanhoMatriz][tamanhoMatriz];

        for (int linha = 0; linha < tamanhoMatriz; linha++) {

            for (int coluna = 0; coluna < tamanhoMatriz; coluna++) {

                if(posicoesTabuleiro[linha][coluna].isNavioPosicionado()){
                    posicoesString[linha][coluna] = '1';
                }else{
                    posicoesString[linha][coluna] = '0';
                }

            }

        }

        return posicoesString;


    }

    public int getNumeroDeNaviosRestantes(boolean isJogador){
        if(isJogador){
            return this.tabuleiroJogador.getQuantidadeNaviosRestantes();
        }else{
            return this.tabuleiroInimigo.getQuantidadeNaviosRestantes();
        }

    }


    public void setPosicaoAleatoria(){

        int linha = ControllerUtils.GerarNumeroAleatorio();

        int coluna = ControllerUtils.GerarNumeroAleatorio();


        PosicaoTabuleiro posicaoTabuleiroAleatoria =  getPosicaoEscolhida(linha,coluna,this.tabuleiroInimigo);

        posicaoTabuleiroAleatoria.setNavioPosicionado(true);

    }


    public boolean setPosicaoTabuleiro(char linha, char coluna){

        int[] posicaoTabuleiro = ControllerUtils.charToInt(linha,coluna);

        PosicaoTabuleiro posicaoEscolhida = getPosicaoEscolhida(posicaoTabuleiro[0],posicaoTabuleiro[1],this.tabuleiroJogador);

        posicaoEscolhida.setNavioPosicionado(true);

        return true;
    }

    public boolean isNavioNaPosicao(char linha, char coluna){

        int[] posicaoTabuleiro = ControllerUtils.charToInt(linha,coluna);
        PosicaoTabuleiro posicaoAtingida;

        posicaoAtingida = getPosicaoEscolhida(posicaoTabuleiro[0],posicaoTabuleiro[1],this.tabuleiroJogador);

        if(posicaoAtingida.isNavioPosicionado()){
            return true;
        }else{
            return false;
        }


    }

    public boolean isNavioNaPosicao(int linha, int coluna){

        PosicaoTabuleiro posicaoAtingida;

        posicaoAtingida = getPosicaoEscolhida(linha,coluna, this.tabuleiroInimigo);


        if(posicaoAtingida.isNavioPosicionado()){
            return true;
        }else{
            return false;
        }


    }

    public boolean atirar(char linha, char coluna){

        int[] posicaoTabuleiro = ControllerUtils.charToInt(linha,coluna);

        PosicaoTabuleiro posicaoEscolhida = getPosicaoEscolhida(posicaoTabuleiro[0],posicaoTabuleiro[1],this.tabuleiroInimigo);

        return isTiroCerteiro(posicaoEscolhida,this.tabuleiroInimigo);


    }

    public boolean atirar(int linha, int coluna){

        PosicaoTabuleiro posicaoEscolhida = getPosicaoEscolhida(linha,coluna,this.tabuleiroJogador);

        return isTiroCerteiro(posicaoEscolhida,this.tabuleiroJogador);

    }



}
