package cotuba.aplicacao;

import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;
import cotuba.epub.GeradorDeEPUB;
import cotuba.md.RenderizadorDeMDParaHTML;
import cotuba.pdf.GeradorDePDF;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public static void executa(String formato, Path diretorioDosMD, Path arquivoDeSaida) {
        RenderizadorDeMDParaHTML renderizadorDeMDParaHTML = new RenderizadorDeMDParaHTML();
        List<Capitulo> capitulos = renderizadorDeMDParaHTML.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        if ("pdf".equals(formato)) {

            GeradorDePDF geradorDePDF = new GeradorDePDF();
            geradorDePDF.geraPDF(ebook);

        } else if ("epub".equals(formato)) {

            GeradorDeEPUB geradorDeEPUB = new GeradorDeEPUB();
            geradorDeEPUB.geraEPUB(ebook);

        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }

    }

}
