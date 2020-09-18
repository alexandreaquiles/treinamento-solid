package br.com.paradizo.tema;

import cotuba.plugin.Tema;

// Service Provider implementa a SPI
public class TemaParadizo implements Tema {

    @Override
    public String cssDoTema() {
        return FileUtils.getResourceContents("/paradizo.css");
    }

}
