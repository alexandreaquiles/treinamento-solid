package cotuba.dominio;

import java.nio.file.Path;
import java.util.List;

public class Ebook implements cotuba.plugin.Ebook {

    private FormatoDoEbook formato;
    private Path arquivoDeSaida;
    private List<Capitulo> capitulos;

    public FormatoDoEbook getFormato() {
        return formato;
    }

    public void setFormato(FormatoDoEbook formato) {
        this.formato = formato;
    }

    public Path getArquivoDeSaida() {
        return arquivoDeSaida;
    }

    public void setArquivoDeSaida(Path arquivoDeSaida) {
        this.arquivoDeSaida = arquivoDeSaida;
    }

    @Override
    public String getFormatoDoEbook() {
        return formato.name();
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }
}
