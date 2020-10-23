package br.com.cognitio;

import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;
import cotuba.plugin.AoFinalizarGeracao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.Normalizer;
import java.util.List;
import java.util.function.Consumer;

public class CalculadoraDeEstatisticas implements AoFinalizarGeracao {

    @Override
    public void aposGeracao(Ebook ebook, Consumer<String> consumer) {

        List<? extends Capitulo> capitulos = ebook.getCapitulos();
        for (Capitulo capitulo: capitulos) {

            String html = capitulo.getConteudoHTML();

            Document document = Jsoup.parse(html);
            String text = document.body().text();

            String textoDoCapituloSemPontuacao = text.replaceAll("\\p{Punct}", " ");
            String decomposta = Normalizer.normalize(textoDoCapituloSemPontuacao, Normalizer.Form.NFD);
            String textoDoCapituloSemAcentos = decomposta.replaceAll("[^\\p{ASCII}]", "");

            String[] palavras = textoDoCapituloSemAcentos.split("\\s+");

            ContadorDePalavras contadorDePalavras = new ContadorDePalavras();
            for (String palavra : palavras) {
                String palavraEmMaiusculas = palavra.toUpperCase().trim();
                contadorDePalavras.adicionaPalavra(palavraEmMaiusculas);
            }

            for (ContadorDePalavras.Contagem contagem : contadorDePalavras) {
                String palavra = contagem.getPalavra();
                Integer quantidade = contagem.getQuantidade();
                consumer.accept(palavra + ":" + quantidade);
            }

        }

    }
}
