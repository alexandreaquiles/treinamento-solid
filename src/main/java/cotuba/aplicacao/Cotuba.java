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
        List<Capitulo> capitulos = RenderizadorDeMDParaHTML.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        if ("pdf".equals(formato)) {

            GeradorDePDF.geraPDF(ebook);

        } else if ("epub".equals(formato)) {

            GeradorDeEPUB.geraEPUB(ebook);

        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }

    }

}
