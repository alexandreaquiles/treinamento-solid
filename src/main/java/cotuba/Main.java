package cotuba;

import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {

		LeitorDeOpcoesDaCLI opcoesCLI = new LeitorDeOpcoesDaCLI(args);

		Path diretorioDosMD = opcoesCLI.getDiretorioDosMD();
		String formato = opcoesCLI.getFormato();
		Path arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
		boolean modoVerboso = opcoesCLI.isModoVerboso();

		try {

			if ("pdf".equals(formato)) {

				GeradorDePDF.geraPDF(diretorioDosMD, arquivoDeSaida);

			} else if ("epub".equals(formato)) {

				GeradorDeEPUB.geraEPUB(diretorioDosMD, arquivoDeSaida);

			} else {
				throw new RuntimeException("Formato do ebook inválido: " + formato);
			}

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
