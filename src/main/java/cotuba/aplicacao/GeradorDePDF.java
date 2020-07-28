package cotuba.aplicacao;

import cotuba.dominio.Ebook;
import cotuba.pdf.GeradorDePDFComIText;

public interface GeradorDePDF {

    static GeradorDePDF cria() {
        return new GeradorDePDFComIText();
    }

    void geraPDF(Ebook ebook);
}
