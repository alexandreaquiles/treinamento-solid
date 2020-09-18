package br.com.paradizo.tema;

import cotuba.dominio.Ebook;
import cotuba.plugin.Plugin;

// Service Provider implementa a SPI
public class TemaParadizo implements Plugin  {
    @Override
    public String cssDoTema() {
        return FileUtils.getResourceContents("/paradizo.css");
    }

    @Override
    public void aposGeracao(Ebook ebook) {
        // nada aqui...
    }
}
