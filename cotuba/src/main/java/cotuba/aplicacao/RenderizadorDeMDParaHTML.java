package cotuba.aplicacao;

import cotuba.plugin.Capitulo;
import cotuba.md.RenderizadorDeMDParaHTMLComCommonMark;

import java.nio.file.Path;
import java.util.List;

public interface RenderizadorDeMDParaHTML {

    static RenderizadorDeMDParaHTML cria() {
        return new RenderizadorDeMDParaHTMLComCommonMark();
    }

    List<Capitulo> renderiza(Path diretorioDosMD);
}
