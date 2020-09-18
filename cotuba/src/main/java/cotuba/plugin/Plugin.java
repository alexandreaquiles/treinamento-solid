package cotuba.plugin;

import cotuba.dominio.Ebook;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

// SPI (Service Provider Interface) - interface está pouco coesa
public interface Plugin {

    String cssDoTema();

    void aposGeracao(Ebook ebook);

    static List<String> listaDeTemas() {
        ServiceLoader<Plugin> loader = ServiceLoader.load(Plugin.class);
        List<String> temas = new ArrayList<>();
        for (Plugin plugin : loader) {
            String css = plugin.cssDoTema();
            temas.add(css);
        }
        return temas;
    }

    static void gerou(Ebook ebook) {
        ServiceLoader<Plugin> loader = ServiceLoader.load(Plugin.class);
        for (Plugin plugin: loader) {
            plugin.aposGeracao(ebook);
        }
    }
}
