package br.com.cognitio;

import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;
import cotuba.plugin.Plugin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

public class CalculadoraDeEstatisticas implements Plugin {

    @Override
    public String cssDoTema() {
        return null;
    }

    @Override
    public void aposGeracao(Ebook ebook) {

        // imprimir as palavras do livro

        List<Capitulo> capitulos = ebook.getCapitulos();
        for (Capitulo capitulo: capitulos) {
            String html = capitulo.getConteudoHTML();

            Document document = Jsoup.parse(html);
            String text = document.body().text();

            String[] palavras = text.split("\\s+");

            for (String palavra : palavras) {
                System.out.println(palavra);
            }
        }

    }
}
