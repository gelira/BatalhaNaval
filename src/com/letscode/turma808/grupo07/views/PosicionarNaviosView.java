package com.letscode.turma808.grupo07.views;

import com.letscode.turma808.grupo07.domain.Tabuleiro;

import java.util.Scanner;

public class PosicionarNaviosView {

    public static String posicao[][]  = new String[10][10];//posicoes dos barcos no tabuleiro//
    int linha, coluna;


    public String[][] posicionarNavios(){
        System.out.println("Informe as posições que deseja colocar seus navios");

        for (int x = 0; x < 10;){
            linha = JogadaView.lerLinha();
            coluna = JogadaView.lerColuna();

            if(posicao[linha][coluna] == null){
                posicao[linha][coluna] = "N";
                x++;
            }else{
                System.out.println("Posição já informada. Informe outras posições.");
            }
        }
        return posicao;
    }

    public String[][] posicionarNaviosAutomatico(){
        for (int x = 0; x < 10;){
            linha = (int)(Math.random() * 9) + 1;
            coluna = (int)(Math.random() * 9) + 1;

            if(posicao[linha][coluna] == null){
                posicao[linha][coluna] = "N";
                x++;
            }
        }
        return posicao;
    }
}
