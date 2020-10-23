package cotuba.tema;

import cotuba.plugin.Tema;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AplicadorDeTema {

    public String aplica(String conteudoHTML) {
        Document document = Jsoup.parse(conteudoHTML);

        Elements head = document.select("head");

        for (String tema : Tema.listaDeTemas()) {
            head.append("<style>" + tema + "</style>");
        }

        return document.html();
    }

}
