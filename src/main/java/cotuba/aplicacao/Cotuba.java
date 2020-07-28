package cotuba.aplicacao;

import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public static void executa(String formato, Path diretorioDosMD, Path arquivoDeSaida) {
        RenderizadorDeMDParaHTML renderizadorDeMDParaHTML = RenderizadorDeMDParaHTML.cria();
        List<Capitulo> capitulos = renderizadorDeMDParaHTML.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        if ("pdf".equals(formato)) {

            GeradorDePDF geradorDePDF = GeradorDePDF.cria();
            geradorDePDF.geraPDF(ebook);

        } else if ("epub".equals(formato)) {

            GeradorDeEPUB geradorDeEPUB = GeradorDeEPUB.cria();
            geradorDeEPUB.geraEPUB(ebook);

        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }

    }

}
