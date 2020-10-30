package cotuba.dominio;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public final class Ebook {

    private final FormatoDoEbook formato;
    private final Path arquivoDeSaida;
    private final List<Capitulo> capitulos;

    public Ebook(FormatoDoEbook formato, Path arquivoDeSaida, List<Capitulo> capitulos) {
        this.formato = formato;
        this.arquivoDeSaida = arquivoDeSaida;
        this.capitulos = Collections.unmodifiableList(capitulos);
    }

    public FormatoDoEbook getFormato() {
        return formato;
    }

    public Path getArquivoDeSaida() {
        return arquivoDeSaida;
    }

    public String getFormatoDoEbook() {
        return formato.name();
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

}
