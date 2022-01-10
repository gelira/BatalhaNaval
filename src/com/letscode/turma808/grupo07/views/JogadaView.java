package com.letscode.turma808.grupo07.views;

import com.letscode.turma808.grupo07.domain.Tabuleiro;

import java.util.Scanner;

public class JogadaView {
    public static void showPosicaoInvalida() {
        System.out.println("Posição selecionada é inválida.");
    }

    public static void showTiroAnterior() {
        System.out.println("Você já atirou na posição selecionada.");
    }

    public static Integer[] askPosicao() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Onde deseja atirar? Informe a posição no formato [A-H][0-9]: ");
        String p = sc.next().toUpperCase();

        if (p.length() != 2) {
            // Posição inválida
            return null;
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
}
