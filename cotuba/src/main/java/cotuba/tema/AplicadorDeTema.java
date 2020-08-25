package cotuba.tema;

import cotuba.dominio.Capitulo;
import cotuba.plugin.Plugin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ServiceLoader;

public class AplicadorDeTema {

    public void aplica(Capitulo capitulo) {
        String conteudoHTML = capitulo.getConteudoHTML();
        Document document = Jsoup.parse(conteudoHTML);
        ServiceLoader<Plugin> loader = ServiceLoader.load(Plugin.class);
        for (Plugin plugin: loader) {
            String css = plugin.cssDoTema();
            document.select("head").append("<style>" + css + "</style>");
        }
        capitulo.setConteudoHTML(document.html());
    }

}
