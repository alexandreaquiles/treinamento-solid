package cotuba.pdf;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.property.AreaBreakType;
import cotuba.dominio.Capitulo;
import cotuba.dominio.Ebook;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GeradorDePDF {

    public void geraPDF(Ebook ebook) {
        List<Capitulo> capitulos = ebook.getCapitulos();
        Path arquivoDeSaida = ebook.getArquivoDeSaida();
        try (PdfWriter writer = new PdfWriter(Files.newOutputStream(arquivoDeSaida));
             PdfDocument pdf = new PdfDocument(writer);
             Document pdfDocument = new Document(pdf)) {

            for (Capitulo capitulo : capitulos) {
                String html = capitulo.getConteudoHTML();
                List<IElement> convertToElements = HtmlConverter.convertToElements(html);
                for (IElement element : convertToElements) {
                    pdfDocument.add((IBlockElement) element);
                }
                // TODO: não adicionar página depois do último capítulo
                pdfDocument.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
            }


        } catch (Exception ex) {
            throw new RuntimeException("Erro ao criar arquivo PDF: " + arquivoDeSaida.toAbsolutePath(), ex);
        }
    }
}
