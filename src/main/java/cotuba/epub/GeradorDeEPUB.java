package cotuba.epub;

import cotuba.dominio.Ebook;

public interface GeradorDeEPUB {

    static GeradorDeEPUB cria() {
        return new GeradorDeEPUBComEpublib();
    }

    void geraEPUB(Ebook ebook);
}
