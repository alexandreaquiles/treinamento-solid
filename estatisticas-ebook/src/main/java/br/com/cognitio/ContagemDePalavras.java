package br.com.cognitio;

import java.util.Map;
import java.util.TreeMap;

public class ContagemDePalavras {

    private Map<String, Integer> map = new TreeMap<>();

    public void adicionaPalavra(String palavra) {
        Integer contagemAtual = map.get(palavra);
        if (contagemAtual == null) {
            map.put(palavra, 1);
        } else {
            map.put(palavra, contagemAtual + 1);
        }
    }

    public Iterable<? extends Map.Entry<String, Integer>> entrySet() {
        return map.entrySet();
    }
}
