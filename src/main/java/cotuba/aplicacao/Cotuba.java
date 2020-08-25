package cotuba.aplicacao;

import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;
import cotuba.dominio.FormatoDoEbook;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public static void executa(ParametrosDoCotuba parametrosDoCotuba) {
        FormatoDoEbook formato = parametrosDoCotuba.getFormato();
        Path diretorioDosMD = parametrosDoCotuba.getDiretorioDosMD();
        Path arquivoDeSaida = parametrosDoCotuba.getArquivoDeSaida();

        RenderizadorDeMDParaHTML renderizadorDeMDParaHTML = RenderizadorDeMDParaHTML.cria();
        List<Capitulo> capitulos = renderizadorDeMDParaHTML.renderiza(diretorioDosMD);

        // for each Capitulo
        // chamar AplicadorDeTema aqui...

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        GeradorDeEbook geradorDeEbook = formato.getGeradorDeEbook();
        geradorDeEbook.gera(ebook);
    }

}
