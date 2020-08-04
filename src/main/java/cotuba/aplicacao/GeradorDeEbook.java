package cotuba.aplicacao;

import cotuba.dominio.Ebook;
import cotuba.epub.GeradorDeEPUB;
import cotuba.pdf.GeradorDePDF;

public interface GeradorDeEbook {

    static GeradorDeEbook cria(String formato) {
        if ("pdf".equals(formato)) {
            return new GeradorDePDF();
        } else if ("epub".equals(formato)) {
            return new GeradorDeEPUB();
        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }
    }

    void gera(Ebook ebook);

}
