package com.letscode.turma808.grupo07.views;

import com.letscode.turma808.grupo07.domain.Tabuleiro;

import java.util.Scanner;

public class PosicionarNaviosView {
    public static void showDescricao() {
        System.out.println("As posições devem ser informadas no formato [A-H][0-9].");
    }

    public static void showMensagemPosicaoInvalida() {
        System.out.println("A posição escolhida não existe ou já tem um navio nela. Escolha novamente.");
    }

    public static Integer[] askPosicao() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe onde quer posicionar o navio: ");
        String p = sc.next();

        if (p.length() != 2) {
            return new Integer[] { null, null };
        }

        char linha = p.charAt(0);
        char coluna = p.charAt(1);

        int linhaIndex = Tabuleiro.LINHAS.indexOf(linha);
        int colunaIndex = Tabuleiro.COLUNAS.indexOf(coluna);

        Integer[] posicao = new Integer[] { null, null };

        if (linhaIndex >= 0) {
            posicao[0] = linhaIndex;
        }
        if (colunaIndex >= 0) {
            posicao[1] = colunaIndex;
        }

        return posicao;
    }

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
