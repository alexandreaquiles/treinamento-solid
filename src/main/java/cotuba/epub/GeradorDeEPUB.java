package cotuba.epub;

import cotuba.dominio.Ebook;

public interface GeradorDeEPUB {

    static GeradorDeEPUB cria() {
        return new GeradorDeEPUBImpl();
    }

    void geraEPUB(Ebook ebook);
}
