package com.letscode.turma808.grupo07.controllers;

import com.letscode.turma808.grupo07.domain.PosicaoTabuleiro;
import com.letscode.turma808.grupo07.domain.Tabuleiro;
import com.letscode.turma808.grupo07.views.NomeJogadorView;
import com.letscode.turma808.grupo07.views.PosicionarNaviosView;
import com.letscode.turma808.grupo07.views.TabuleiroView;

import javax.sound.midi.ControllerEventListener;
import java.util.Random;

public class TabuleiroController {

    private Tabuleiro tabuleiro;

    public TabuleiroController() {

        String nome = NomeJogadorView.askNomeJogador();

        tabuleiro = new Tabuleiro(nome);

    }

    public PosicaoTabuleiro getPosicaoRandom() {
        Random r = new Random();
        return getPosicao(r.nextInt(Tabuleiro.LINHAS.length()), r.nextInt(Tabuleiro.COLUNAS.length()));
    }

    private PosicaoTabuleiro getPosicao(int linhaIndex, int colunaIndex) {
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
            Integer linha = coordenada[0];
            Integer coluna = coordenada[1];

            if (linha == null || coluna == null) {
                PosicionarNaviosView.showMensagemPosicaoInvalida();
                continue;
            }

            PosicaoTabuleiro posicao = getPosicao(linha, coluna);

            if (posicao.getNavioPosicionado()) {
                PosicionarNaviosView.showMensagemPosicaoInvalida();
                continue;
            }

            posicao.setNavioPosicionado(true);
            tabuleiro.incQuantidadeNaviosRestantes();

        }
    }
    
    private PosicaoTabuleiro getPosicaoEscolhida(int linha, int coluna, Tabuleiro tabuleiro){

        PosicaoTabuleiro[][] posicoesDoTabuleiro = tabuleiro.getPosicoes();

        PosicaoTabuleiro posicaoEscolhida = posicoesDoTabuleiro[linha][coluna];

        return posicaoEscolhida;

    }

    public void showTabuleiro() {
        TabuleiroView.imprimeTabuleiro(tabuleiro);
    }

    /*private boolean isTiroCerteiro(PosicaoTabuleiro posicaoEscolhida,Tabuleiro tabuleiro){

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

    }*/

    /*public char[][] getPosicoesTabuleiro(boolean isJogador){

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


    }*/

    /*public int getNumeroDeNaviosRestantes(boolean isJogador){
        if(isJogador){
            return this.tabuleiroJogador.getQuantidadeNaviosRestantes();
        }else{
            return this.tabuleiroInimigo.getQuantidadeNaviosRestantes();
        }

    }*/


/*    public void setPosicaoAleatoria(){

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
    }*/

    /*public boolean isNavioNaPosicao(char linha, char coluna){

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

    }*/



}
