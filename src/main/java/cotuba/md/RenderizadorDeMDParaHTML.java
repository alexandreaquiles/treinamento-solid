package cotuba.md;

import cotuba.dominio.Capitulo;

import java.nio.file.Path;
import java.util.List;

public interface RenderizadorDeMDParaHTML {

    static RenderizadorDeMDParaHTML cria() {
        return new RenderizadorDeMDParaHTMLImpl();
    }

    List<Capitulo> renderiza(Path diretorioDosMD);
}
