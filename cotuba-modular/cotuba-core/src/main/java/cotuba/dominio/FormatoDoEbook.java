package cotuba.dominio;

import cotuba.aplicacao.GeradorDeEbook;
import cotuba.epub.GeradorDeEPUB;
import cotuba.pdf.GeradorDePDF;

public enum FormatoDoEbook {

    PDF(new GeradorDePDF()),
    EPUB(new GeradorDeEPUB());

    private GeradorDeEbook geradorDeEbook;

    FormatoDoEbook(GeradorDeEbook geradorDeEbook) {
        this.geradorDeEbook = geradorDeEbook;
    }

    public GeradorDeEbook getGeradorDeEbook() {
        return geradorDeEbook;
    }
}
