package com.letscode.turma808.grupo07.views;

public class TabuleiroView {

    public static String tabuleiro[][]= new String[10][10];//cria um tabuleiro  10x10//
    public static void imprimeTabuleiro(){

        System.out.println("    0   1   2   3   4   5   6   7   8   9"); //numero da coluna
        System.out.println("  _________________________________________");
        for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 9//
            System.out.print(l + " ");   //numero da linhas do lado do tabuleiro
            for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 9//
                System.out.print("| "+tabuleiro[l][c]+" ");
            }
            System.out.println("|");
            System.out.println("  _________________________________________");
        }
    }

    public static void inicilizaMatriz(){
        for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 9//
            for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 9//
                tabuleiro[l][c]=" ";
            }
        }
    }

    public static void posicionaNaviosTabuleiro(String[][] posicao){
        for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 9//
            for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 9//
                if(posicao[l][c] != null)
                    tabuleiro[l][c]=posicao[l][c];
            }
        }
    }

}
