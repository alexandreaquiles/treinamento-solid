package cotuba.cli;

import cotuba.aplicacao.Cotuba;

import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {

		boolean modoVerboso = LeitorDeOpcoesDaCLI.MODO_VERBOSO_PADRAO;

		try {

			LeitorDeOpcoesDaCLI opcoesCLI = new LeitorDeOpcoesDaCLI(args);

			Path diretorioDosMD = opcoesCLI.getDiretorioDosMD();
			String formato = opcoesCLI.getFormato();
			Path arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
			modoVerboso = opcoesCLI.isModoVerboso();

			Cotuba.executa(formato, diretorioDosMD, arquivoDeSaida);

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
