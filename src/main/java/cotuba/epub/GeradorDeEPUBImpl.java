package cotuba.epub;

import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GeradorDeEPUBImpl implements GeradorDeEPUB {

    @Override
    public void geraEPUB(Ebook ebook) {
        List<Capitulo> capitulos = ebook.getCapitulos();
        Path arquivoDeSaida = ebook.getArquivoDeSaida();

        Book epub = new Book();

        for (Capitulo capitulo : capitulos) {
            String html = capitulo.getConteudoHTML();
            String titulo = capitulo.getTitulo();
            epub.addSection(titulo, new Resource(html.getBytes(), MediatypeService.XHTML));
        }

        EpubWriter epubWriter = new EpubWriter();

        try {
            epubWriter.write(epub, Files.newOutputStream(arquivoDeSaida));
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao criar arquivo EPUB: " + arquivoDeSaida.toAbsolutePath(), ex);
        }
    }
}
