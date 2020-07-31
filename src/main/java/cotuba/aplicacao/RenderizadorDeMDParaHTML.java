package cotuba.aplicacao;

import cotuba.dominio.Capitulo;

import java.nio.file.Path;
import java.util.List;

public interface RenderizadorDeMDParaHTML {

    List<Capitulo> renderiza(Path diretorioDosMD);

}
