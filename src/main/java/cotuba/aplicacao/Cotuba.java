package cotuba.aplicacao;

import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;
import cotuba.epub.GeradorDeEPUB;
import cotuba.epub.GeradorDeEPUBImpl;
import cotuba.md.RenderizadorDeMDParaHTML;
import cotuba.md.RenderizadorDeMDParaHTMLImpl;
import cotuba.pdf.GeradorDePDF;
import cotuba.pdf.GeradorDePDFImpl;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public static void executa(String formato, Path diretorioDosMD, Path arquivoDeSaida) {
        RenderizadorDeMDParaHTML renderizadorDeMDParaHTML = new RenderizadorDeMDParaHTMLImpl();
        List<Capitulo> capitulos = renderizadorDeMDParaHTML.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        if ("pdf".equals(formato)) {

            GeradorDePDF geradorDePDF = new GeradorDePDFImpl();
            geradorDePDF.geraPDF(ebook);

        } else if ("epub".equals(formato)) {

            GeradorDeEPUB geradorDeEPUB = new GeradorDeEPUBImpl();
            geradorDeEPUB.geraEPUB(ebook);

        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }

    }

}
