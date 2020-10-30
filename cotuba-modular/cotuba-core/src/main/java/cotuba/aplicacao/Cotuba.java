package cotuba.aplicacao;

import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;
import cotuba.dominio.FormatoDoEbook;
import cotuba.plugin.AoFinalizarGeracao;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

public interface Cotuba {

    static void executa(ParametrosDoCotuba parametrosDoCotuba, Consumer<String> consumer) {
        FormatoDoEbook formato = parametrosDoCotuba.getFormato();
        Path diretorioDosMD = parametrosDoCotuba.getDiretorioDosMD();
        Path arquivoDeSaida = parametrosDoCotuba.getArquivoDeSaida();

        RenderizadorDeMDParaHTML renderizadorDeMDParaHTML = RenderizadorDeMDParaHTML.cria();
        List<Capitulo> capitulos = renderizadorDeMDParaHTML.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook(formato, arquivoDeSaida, capitulos);

        GeradorDeEbook geradorDeEbook = formato.getGeradorDeEbook();
        geradorDeEbook.gera(ebook);

        AoFinalizarGeracao.gerou(ebook, consumer);
    }

}
