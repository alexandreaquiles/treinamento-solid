package cotuba.tema;

import cotuba.dominio.Capitulo;
import cotuba.plugin.Tema;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AplicadorDeTema {

    public void aplica(Capitulo capitulo) {
        String conteudoHTML = capitulo.getConteudoHTML();
        Document document = Jsoup.parse(conteudoHTML);

        Elements head = document.select("head");

        for (String tema : Tema.listaDeTemas()) {
            head.append("<style>" + tema + "</style>");
        }

        capitulo.setConteudoHTML(document.html());
    }

}
