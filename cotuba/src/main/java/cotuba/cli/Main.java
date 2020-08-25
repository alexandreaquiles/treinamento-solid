package cotuba.cli;

import cotuba.aplicacao.Cotuba;

import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {

		boolean modoVerboso = LeitorDeOpcoesDaCLI.MODO_VERBOSO_PADRAO;

		try {

			LeitorDeOpcoesDaCLI opcoesDaCLI = new LeitorDeOpcoesDaCLI(args);

			Path arquivoDeSaida = opcoesDaCLI.getArquivoDeSaida();
			modoVerboso = opcoesDaCLI.isModoVerboso();

			Cotuba.executa(opcoesDaCLI);

			System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			if (modoVerboso) {
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}

}
