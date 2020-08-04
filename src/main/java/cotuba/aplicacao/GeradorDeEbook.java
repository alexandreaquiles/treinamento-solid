package cotuba.aplicacao;

import cotuba.dominio.Ebook;
import cotuba.dominio.FormatoDoEbook;
import cotuba.epub.GeradorDeEPUB;
import cotuba.pdf.GeradorDePDF;

import java.util.Map;

public interface GeradorDeEbook {

    Map<FormatoDoEbook, GeradorDeEbook> GERADORES = Map.of(
            FormatoDoEbook.PDF, new GeradorDePDF(),
            FormatoDoEbook.EPUB, new GeradorDeEPUB()
    );

    static GeradorDeEbook cria(FormatoDoEbook formato) {
        GeradorDeEbook geradorDeEbook = GERADORES.get(formato);
        if (geradorDeEbook == null) {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }
        return geradorDeEbook;
    }

    void gera(Ebook ebook);

}
