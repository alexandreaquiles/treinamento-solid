package cotuba.tema;

import cotuba.dominio.Capitulo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AplicadorDeTema {

    public void aplica(Capitulo capitulo) {
        String conteudoHTML = capitulo.getConteudoHTML();
        Document document = Jsoup.parse(conteudoHTML);
        document.select("head").append("<style>h1 { border-bottom: 1px solid black; }</style>");
        capitulo.setConteudoHTML(document.html());
    }

}
