package cotuba.aplicacao;

import cotuba.dominio.Ebook;
import cotuba.epub.GeradorDeEPUBComEpublib;

public interface GeradorDeEPUB {

    static GeradorDeEPUB cria() {
        return new GeradorDeEPUBComEpublib();
    }

    void geraEPUB(Ebook ebook);
}
