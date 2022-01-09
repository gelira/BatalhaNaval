package com.letscode.turma808.grupo07.views;

import java.util.Scanner;

public class NomeJogadorView {

    public static String askNomeJogador(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do jogador: ");

        String nome = sc.next();


        return nome;


    }

}
