package cotuba.pdf;

import cotuba.dominio.Ebook;

public interface GeradorDePDF {

    static GeradorDePDF cria() {
        return new GeradorDePDFImpl();
    }

    void geraPDF(Ebook ebook);
}
