package cotuba.cli;

import cotuba.aplicacao.Cotuba;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class CLI {

	private final Cotuba cotuba;

	public CLI(Cotuba cotuba) {
		this.cotuba = cotuba;
	}

	public void executa(String[] args) {

		boolean modoVerboso = LeitorDeOpcoesDaCLI.MODO_VERBOSO_PADRAO;

		try {

			LeitorDeOpcoesDaCLI opcoesCLI = new LeitorDeOpcoesDaCLI(args);

			Path diretorioDosMD = opcoesCLI.getDiretorioDosMD();
			String formato = opcoesCLI.getFormato();
			Path arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
			modoVerboso = opcoesCLI.isModoVerboso();

			cotuba.executa(formato, diretorioDosMD, arquivoDeSaida);

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
