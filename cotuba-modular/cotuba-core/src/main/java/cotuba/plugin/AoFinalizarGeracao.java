package cotuba.plugin;

import cotuba.dominio.Ebook;

import java.util.ServiceLoader;
import java.util.function.Consumer;

// SPI (Service Provider Interface) - interface está pouco coesa
public interface AoFinalizarGeracao {

    void aposGeracao(Ebook ebook, Consumer<String> consumer);

    static void gerou(Ebook ebook, Consumer<String> consumer) {
        ServiceLoader<AoFinalizarGeracao> loader = ServiceLoader.load(AoFinalizarGeracao.class);
        for (AoFinalizarGeracao aoFinalizarGeracao : loader) {
            aoFinalizarGeracao.aposGeracao(ebook, consumer);
        }
    }
}
