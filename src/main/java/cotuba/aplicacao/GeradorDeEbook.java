package cotuba.aplicacao;

import cotuba.dominio.Ebook;
import cotuba.epub.GeradorDeEPUB;
import cotuba.pdf.GeradorDePDF;

import java.util.Map;

public interface GeradorDeEbook {

    Map<String, GeradorDeEbook> GERADORES = Map.of("pdf", new GeradorDePDF(),
            "epub", new GeradorDeEPUB());

    static GeradorDeEbook cria(String formato) {
        GeradorDeEbook geradorDeEbook = GERADORES.get(formato);
        if (geradorDeEbook == null) {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }
        return geradorDeEbook;
    }

    void gera(Ebook ebook);

}
