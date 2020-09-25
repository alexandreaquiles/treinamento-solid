package cotuba.plugin;

import cotuba.dominio.FormatoDoEbook;

import java.util.List;

public interface Ebook {
    String getFormatoDoEbook();
    List<? extends Capitulo> getCapitulos();
}
