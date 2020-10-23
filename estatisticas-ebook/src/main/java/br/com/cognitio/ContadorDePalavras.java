package br.com.cognitio;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ContadorDePalavras implements Iterable<ContadorDePalavras.Contagem> {

    private Map<String, Integer> map = new TreeMap<>();

    public void adicionaPalavra(String palavra) {
        Integer contagemAtual = map.get(palavra);
        if (contagemAtual == null) {
            map.put(palavra, 1);
        } else {
            map.put(palavra, contagemAtual + 1);
        }
    }

    @Override
    public Iterator<Contagem> iterator() {
        return new Iterator<>() {

            private Iterator<Map.Entry<String, Integer>> mapIterator = map.entrySet().iterator();

            @Override
            public boolean hasNext() {
                return mapIterator.hasNext();
            }

            @Override
            public Contagem next() {
                Map.Entry<String, Integer> entry = mapIterator.next();
                String palavra = entry.getKey();
                Integer quantidade = entry.getValue();
                return new Contagem(palavra, quantidade);
            }
        };
    }

    public class Contagem {

        private final String palavra;
        private final Integer quantidade;

        public Contagem(String palavra, Integer quantidade) {
            this.palavra = palavra;
            this.quantidade = quantidade;
        }

        public String getPalavra() {
            return palavra;
        }

        public Integer getQuantidade() {
            return quantidade;
        }
    }

}
