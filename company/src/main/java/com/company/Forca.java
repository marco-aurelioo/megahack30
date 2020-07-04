package com.company;

import java.util.Random;
import java.util.Scanner;


public class Forca {

    public static void main(String[] args) {
        Random random = new Random();
        // SCANNER
        Scanner in = new Scanner(System.in);
        //lista de palavras
        String[] palavra1 = {"ARTHUR", "BERNARDO", "DAVID", "GABRIEL", "HEITOR",
                "LUCAS", "LORENZO", "MIGUEL", "MATHEUS", "PEDRO", "NIVALDO", "ROBER",
                "LUIZ", "CARLOS", "DANILO", "REGINALDO", "JORGE", "ROBER", "JORLAINE", "MARCOS"};
        //quantidade de palavras
        int quantPalavra1 = palavra1.length;
        int indiceSorteado1 = random.nextInt(quantPalavra1);// indice sorteado
        String sorteada1 = palavra1[indiceSorteado1];// a palavra sorteada
        char[] acertos1 = new char[sorteada1.length()];
        for (int i = 0; i < acertos1.length; i++) {
            acertos1[i] = 0;
        }
        String letrasUtilizadas1 = "";
        String letra1;

        boolean ganhou1 = false;
        int vidas1 = 6;
        System.out.println("###################");
        System.out.println("## Jogo da Forca ##");
        System.out.println("###################");
        do {
            if (vidas1 == 6) {
                System.out.println("_______________");
                System.out.println("| /          |");
                System.out.println("|/           |");
                System.out.println("|             ");
                System.out.println("|             ");
                System.out.println("|             ");
                System.out.println("____          ");
            } else {
                if (vidas1 == 5) {
                    System.out.println("_______________");
                    System.out.println("| /          |");
                    System.out.println("|/           |");
                    System.out.println("|            O ");
                    System.out.println("|             ");
                    System.out.println("|             ");
                    System.out.println("____          ");
                } else {
                    if (vidas1 == 4) {
                        System.out.println("_______________");
                        System.out.println("| /          |");
                        System.out.println("|/           |");
                        System.out.println("|            O ");
                        System.out.println("|            | ");
                        System.out.println("|            |");
                        System.out.println("____          ");
                    } else {
                        if (vidas1 == 3) {
                            System.out.println("_______________");
                            System.out.println("| /          |");
                            System.out.println("|/           |");
                            System.out.println("|            O ");
                            System.out.println("|           [| ");
                            System.out.println("|            |");
                            System.out.println("____          ");
                        } else {
                            if (vidas1 == 2) {
                                System.out.println("_______________");
                                System.out.println("| /          |");
                                System.out.println("|/           |");
                                System.out.println("|            O ");
                                System.out.println("|           [|]");
                                System.out.println("|            |");
                                System.out.println("____          ");
                            } else {
                                if (vidas1 == 1) {
                                    System.out.println("_______________");
                                    System.out.println("| /          |");
                                    System.out.println("|/           |");
                                    System.out.println("|            O ");
                                    System.out.println("|           [|] ");
                                    System.out.println("|            |");
                                    System.out.println("____        [ ]");
                                } else {
                                    if (vidas1 == 0) {
                                        System.out.println("_______________");
                                        System.out.println("| /          |");
                                        System.out.println("|/           |");
                                        System.out.println("|            O ");
                                        System.out.println("|           [|] ");
                                        System.out.println("|            |");
                                        System.out.println("____        [ ]");
                                        System.out.println("Você foi enforcado");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("\nVocê tem " + vidas1 + " vidas");
            System.out.println("Letras utiizadas: " + letrasUtilizadas1);
            System.out.println("Qual letra deseja tentar? ");
            letra1 = in.next();
            if (letra1.length() > 1) {
                System.out.println("Digite apenas 1 letra? ");
            } else {
                letra1 = letra1.toUpperCase();
                char letra = letra1.charAt(0);
                letrasUtilizadas1 += " " + letra1;
                boolean perdeVida1 = true;
                //System.out.println(sorteada1);
                for (int i = 0; i < sorteada1.length(); i++) {
                    //verifica se a letra digitada é igual a letra da palavra sorteada
                    // na posição i
                    if (letra == sorteada1.charAt(i)) {
                        System.out.println("Tem essa letra na posição " + i );
                        acertos1[i] = letra;
                        perdeVida1 = false;
                    }
                }

                if (perdeVida1)
                    vidas1--;
                System.out.println("\n");
                ganhou1 = true;
                for (int i = 0; i < sorteada1.length(); i++) {
                    if (acertos1[i] == 0) {
                        System.out.print(" __ ");
                        ganhou1 = false;
                    } else {
                        System.out.print(" " + sorteada1.charAt(i) + " ");
                    }
                }
                System.out.println("\n");
            }
        }while (!ganhou1 && vidas1 > 0) ;
        if (vidas1 > 0) {
            System.out.println("\nParabens, você é um genio das palavras!!");
        } else {
            System.out.println("GAMER OVER");
            System.out.println("Mais sorte na Proxima vez");
            System.out.println("A palavra era: " + sorteada1);
        }
    }
}
