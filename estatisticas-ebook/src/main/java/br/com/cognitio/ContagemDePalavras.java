package br.com.cognitio;

import java.util.HashMap;

public class ContagemDePalavras extends HashMap<String, Integer> {

    public void adicionaPalavra(String palavra) {
        Integer contagemAtual = this.get(palavra);
        if (contagemAtual == null) {
            this.put(palavra, 1);
        } else {
            this.put(palavra, contagemAtual + 1);
        }
    }

}
