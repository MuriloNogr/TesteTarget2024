package br.com.target.teste03;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T3 {

    public static void main(String[] args) {
        String caminhoArquivo = "faturamento.json";
        JSONArray dadosFaturamento = lerArquivoJSON(caminhoArquivo);

        if (dadosFaturamento != null) {
            calcularEstatisticasFaturamento(dadosFaturamento);
        }
    }

    public static JSONArray lerArquivoJSON(String caminhoArquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha);
            }
            return new JSONArray(conteudo.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void calcularEstatisticasFaturamento(JSONArray dadosFaturamento) {
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double somaFaturamento = 0.0;
        int diasComFaturamento = 0;

        for (int i = 0; i < dadosFaturamento.length(); i++) {
            JSONObject diaFaturamento = dadosFaturamento.getJSONObject(i);
            double valor = diaFaturamento.getDouble("valor");

            if (valor > 0) {
                if (valor < menorValor) {
                    menorValor = valor;
                }
                if (valor > maiorValor) {
                    maiorValor = valor;
                }
                somaFaturamento += valor;
                diasComFaturamento++;
            }
        }

        double mediaMensal = somaFaturamento / diasComFaturamento;
        int diasAcimaMedia = 0;

        for (int i = 0; i < dadosFaturamento.length(); i++) {
            JSONObject diaFaturamento = dadosFaturamento.getJSONObject(i);
            double valor = diaFaturamento.getDouble("valor");

            if (valor > mediaMensal) {
                diasAcimaMedia++;
            }
        }

        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Dias com faturamento acima da média: " + diasAcimaMedia);
    }
}
