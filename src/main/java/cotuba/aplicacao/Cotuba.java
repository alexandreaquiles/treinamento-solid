package cotuba.aplicacao;

import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.List;

@Component
public class Cotuba {

    private final RenderizadorDeMDParaHTML renderizadorDeMDParaHTML;
    private final GeradorDePDF geradorDePDF;
    private final GeradorDeEPUB geradorDeEPUB;

    public Cotuba(RenderizadorDeMDParaHTML renderizadorDeMDParaHTML,
                  GeradorDePDF geradorDePDF,
                  GeradorDeEPUB geradorDeEPUB) {
        this.renderizadorDeMDParaHTML = renderizadorDeMDParaHTML;
        this.geradorDePDF = geradorDePDF;
        this.geradorDeEPUB = geradorDeEPUB;
    }

    public void executa(String formato, Path diretorioDosMD, Path arquivoDeSaida) {
        List<Capitulo> capitulos = renderizadorDeMDParaHTML.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        if ("pdf".equals(formato)) {

            geradorDePDF.geraPDF(ebook);

        } else if ("epub".equals(formato)) {

            geradorDeEPUB.geraEPUB(ebook);

        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }

    }

}
