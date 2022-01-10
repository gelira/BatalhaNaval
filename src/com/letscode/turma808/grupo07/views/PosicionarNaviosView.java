package com.letscode.turma808.grupo07.views;

import com.letscode.turma808.grupo07.domain.Tabuleiro;

import java.util.Scanner;

public class PosicionarNaviosView {
    public static void showDescricao() {
        System.out.println("As posições devem ser informadas como [A-H][0-9]. Informe XX para uma posição aleatória.");
    }

    public static void showMensagemPosicaoInvalida() {
        System.out.println("A posição escolhida não existe ou já tem um navio nela. Escolha novamente.");
    }

    public static Integer[] askPosicao(int posicoesRestantes) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Informe onde quer posicionar o navio (faltam %d navios): ", posicoesRestantes);
        String p = sc.next().toUpperCase();

        if (p.length() != 2) {
            // Posição inválida
            return null;
        }

        if (p.equals("XX")) {
            // Posição aleatória
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
}
