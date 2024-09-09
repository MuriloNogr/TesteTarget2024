package br.com.target.teste01;

public class T1 {
    public static void main(String[] args) {
        int indice = 13, soma = 0, k = 0;

        while (k < indice) {
            k = k + 1;
            soma += k;
        }

        System.out.println("O resultado é de: " + soma);
    }
}
