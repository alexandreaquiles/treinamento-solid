package cotuba.aplicacao;

import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;
import cotuba.epub.GeradorDeEPUB;
import cotuba.pdf.GeradorDePDF;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public static void executa(ParametrosDoCotuba parametrosDoCotuba) {
        String formato = parametrosDoCotuba.getFormato();
        Path diretorioDosMD = parametrosDoCotuba.getDiretorioDosMD();
        Path arquivoDeSaida = parametrosDoCotuba.getArquivoDeSaida();

        RenderizadorDeMDParaHTML renderizadorDeMDParaHTML = RenderizadorDeMDParaHTML.cria();
        List<Capitulo> capitulos = renderizadorDeMDParaHTML.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        GeradorDeEbook geradorDeEbook;

        if ("pdf".equals(formato)) {
             geradorDeEbook = new GeradorDePDF();
        } else if ("epub".equals(formato)) {
            geradorDeEbook = new GeradorDeEPUB();
        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }

        geradorDeEbook.gera(ebook);
    }

}
