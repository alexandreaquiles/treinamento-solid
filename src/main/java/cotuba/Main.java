package cotuba;

import java.nio.file.Path;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		LeitorDeOpcoesDaCLI opcoesCLI = new LeitorDeOpcoesDaCLI(args);

		Path diretorioDosMD = opcoesCLI.getDiretorioDosMD();
		String formato = opcoesCLI.getFormato();
		Path arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
		boolean modoVerboso = opcoesCLI.isModoVerboso();

		try {

			List<String> htmlsRenderizados = RenderizadorDeMDParaHTML.renderiza(diretorioDosMD);

			if ("pdf".equals(formato)) {

				GeradorDePDF.geraPDF(htmlsRenderizados, arquivoDeSaida);

			} else if ("epub".equals(formato)) {

				GeradorDeEPUB.geraEPUB(htmlsRenderizados, arquivoDeSaida);

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
