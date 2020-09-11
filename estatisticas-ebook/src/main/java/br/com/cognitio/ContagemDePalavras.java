package br.com.cognitio;

import java.util.Collection;
import java.util.TreeMap;

public class ContagemDePalavras extends TreeMap<String, Integer> {
                               // é um tipo especial de (FAKE NEWS)
    // herança
    public void adicionaPalavra(String palavra) {
        Integer contagemAtual = this.get(palavra);
        if (contagemAtual == null) {
            this.put(palavra, 1);
        } else {
            this.put(palavra, contagemAtual + 1);
        }
    }
}
