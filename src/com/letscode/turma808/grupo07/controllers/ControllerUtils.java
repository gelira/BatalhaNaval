package com.letscode.turma808.grupo07.controllers;

import java.util.Random;

public class ControllerUtils {


    public static int LinhasParaNumero(char coluna){
        int numeroColuna = -1;

        switch(Character.toUpperCase(coluna)){

            case'A':
                numeroColuna = 0;
                break;
            case'B':
                numeroColuna = 1;
                break;
            case'C':
                numeroColuna = 2;
                break;
            case'D':
                numeroColuna = 3;
                break;
            case'E':
                numeroColuna = 4;
                break;
            case'F':
                numeroColuna = 5;
                break;
            case'G':
                numeroColuna = 6;
                break;
            case'H':
                numeroColuna = 7;
                break;
            case'I':
                numeroColuna = 8;
                break;
            case'J':
                numeroColuna = 9;
                break;
        }

        return numeroColuna;

    }

    public static int GerarNumeroAleatorio(){
        Random numeroAleatorio = new Random();

        return numeroAleatorio.nextInt(10);
    }

    public static int[] charToInt(char linha, char coluna){

        int[] posicaoTabuleiroFormatada = new int[2];

        posicaoTabuleiroFormatada[0] = ControllerUtils.LinhasParaNumero(linha);

        posicaoTabuleiroFormatada[1] = Character.getNumericValue(coluna);

        return posicaoTabuleiroFormatada;

    }



}
