package br.com.cognitio;

import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;
import cotuba.plugin.Plugin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.Normalizer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculadoraDeEstatisticas implements Plugin {

    @Override
    public String cssDoTema() {
        return null;
    }

    @Override
    public void aposGeracao(Ebook ebook) {

        List<Capitulo> capitulos = ebook.getCapitulos();
        for (Capitulo capitulo: capitulos) {
            String html = capitulo.getConteudoHTML();

            Document document = Jsoup.parse(html);
            String text = document.body().text();

            String textoDoCapituloSemPontuacao = text.replaceAll("\\p{Punct}", " ");
            String decomposta = Normalizer.normalize(textoDoCapituloSemPontuacao, Normalizer.Form.NFD);
            String textoDoCapituloSemAcentos = decomposta.replaceAll("[^\\p{ASCII}]", "");

            String[] palavras = textoDoCapituloSemAcentos.split("\\s+");

            ContagemDePalavras contagemDeTodasAsPalavras = new ContagemDePalavras();
            for (String palavra : palavras) {
                String palavraEmMaiusculas = palavra.toUpperCase().trim();
                contagemDeTodasAsPalavras.adicionaPalavra(palavraEmMaiusculas);
            }

//            contagemDeTodasAsPalavras.clear();
//            contagemDeTodasAsPalavras.replace(...);

//            Integer quantidade = contagemDeTodasAsPalavras.get("Abacate");

            for (Map.Entry<String, Integer> par: contagemDeTodasAsPalavras.entrySet()) {
                String palavra = par.getKey();
                Integer contagem = par.getValue();
                System.out.println(palavra + ":" + contagem);
            }

        }

    }
}
