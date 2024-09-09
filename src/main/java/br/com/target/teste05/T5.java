package br.com.target.teste05;

import java.util.Scanner;

public class T5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inversor de Strings");
        System.out.println("---------------------------");
        System.out.println("Digite uma String: ");
        String s = sc.nextLine();
        sc.close();
        String sr = inversor(s);
        System.out.println("A String " + s + " invertida fica: " + sr);

    }

    public static String inversor(String s) {
        char[] letras = s.toCharArray();
        int comeco = 0;
        int fim = letras.length - 1;
        while (comeco < fim) {
            char temp = letras[comeco];
            letras[comeco] = letras[fim];
            letras[fim] = temp;
            comeco++;
            fim--;
        }
        return new String(letras);
    }


}
