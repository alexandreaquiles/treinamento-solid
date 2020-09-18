package cotuba.plugin;

import cotuba.dominio.Ebook;

import java.util.ServiceLoader;

// SPI (Service Provider Interface) - interface está pouco coesa
public interface AoFinalizarGeracao {

    void aposGeracao(Ebook ebook);

    static void gerou(Ebook ebook) {
        ServiceLoader<AoFinalizarGeracao> loader = ServiceLoader.load(AoFinalizarGeracao.class);
        for (AoFinalizarGeracao aoFinalizarGeracao : loader) {
            aoFinalizarGeracao.aposGeracao(ebook);
        }
    }
}
