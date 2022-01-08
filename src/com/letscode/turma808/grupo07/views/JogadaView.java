package com.letscode.turma808.grupo07.views;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JogadaView {

    public static int posicao[][]  = new int[10][10];//posicoes dos barcos no tabuleiro//

    public static void zeraPosicao(){
        for(int l=0;l<10;l++){//preenche as linhas com 0//
            for(int c=0;c<10;c++){//preenche as colunas com 0//
                posicao[l][c] = 0;
            }
        }
    }


    public static int lerLinha(){
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int linha = 0;
        try {
            System.out.println("Informe a linha: ");
            linha = Integer.parseInt(entrada.readLine());
            if(linha >=0 && linha < 10){
                return(linha);
            }else{
                System.out.println("Linha invalida!!!");
                return(lerLinha());
            }
        } catch(Exception e){
            System.out.println("Linha invalida!!!");
            return(lerLinha());
        }
    }

    public static int lerColuna(){
        BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
        int coluna = 0;

        try {
            System.out.println("Informe a coluna: ");
            coluna = Integer.parseInt(entrada.readLine());
            if(coluna >= 0 && coluna < 10){
                return(coluna);
            }else{
                System.out.println("Coluna invalida!!!");
                return(lerColuna());
            }
        } catch(Exception e){
            System.out.println("Coluna invalida!!!");
            return(lerColuna());
        }
    }

}
