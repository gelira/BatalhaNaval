package com.letscode.turma808.grupo07.views;

public class UtilView {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
