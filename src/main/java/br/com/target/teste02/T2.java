package br.com.target.teste02;


import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Verificador Fibonacci");
        System.out.println("---------------------------");
        System.out.println("Qual número deseja verificar: ");

        int n1 = sc.nextInt();

        sc.close();


        if (verificador(n1)) {
            System.out.println(n1 + " pertence à sequência de Fibonacci");
        } else {
            System.out.println(n1 + " não pertence à sequência de Fibonacci");
        }
    }

    public static boolean verificador(int n1) {
        int f1 = 0;
        int f2 = 1;


        while (f1 <= n1) {
            if (f1 == n1) {
                return true;
            }
            int prox = f1 + f2;
            f1 = f2;
            f2 = prox;
        }

        return false;
    }
}
