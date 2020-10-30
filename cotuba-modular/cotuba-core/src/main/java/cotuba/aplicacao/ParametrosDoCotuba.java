package cotuba.aplicacao;

import cotuba.dominio.FormatoDoEbook;

import java.nio.file.Path;

public interface ParametrosDoCotuba {
    FormatoDoEbook getFormato();
    Path getDiretorioDosMD();
    Path getArquivoDeSaida();
}
