package cotuba.pdf;

import cotuba.dominio.Ebook;

public interface GeradorDePDF {

    static GeradorDePDF cria() {
        return new GeradorDePDFComIText();
    }

    void geraPDF(Ebook ebook);
}
