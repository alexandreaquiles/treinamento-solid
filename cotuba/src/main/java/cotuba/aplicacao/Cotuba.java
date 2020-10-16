package cotuba.aplicacao;

import cotuba.plugin.Capitulo;
import cotuba.dominio.Ebook;
import cotuba.dominio.FormatoDoEbook;
import cotuba.plugin.AoFinalizarGeracao;

import java.nio.file.Path;
import java.util.List;

public interface Cotuba {

    public static void executa(ParametrosDoCotuba parametrosDoCotuba) {
        FormatoDoEbook formato = parametrosDoCotuba.getFormato();
        Path diretorioDosMD = parametrosDoCotuba.getDiretorioDosMD();
        Path arquivoDeSaida = parametrosDoCotuba.getArquivoDeSaida();

        RenderizadorDeMDParaHTML renderizadorDeMDParaHTML = RenderizadorDeMDParaHTML.cria();
        List<Capitulo> capitulos = renderizadorDeMDParaHTML.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        GeradorDeEbook geradorDeEbook = formato.getGeradorDeEbook();
        geradorDeEbook.gera(ebook);

        AoFinalizarGeracao.gerou(ebook);
    }

}
