package PdfConverter.PdfConverter.Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class TextToPdf {

	public static void TextToPdf(String qFichero) throws DocumentException, IOException {

		Document pdf = new Document(PageSize.A4);
		PdfWriter.getInstance(pdf, new FileOutputStream(new File("src/main/java/resources/txt.pdf")))
				.setPdfVersion(PdfWriter.PDF_VERSION_1_7);

		pdf.open();

		Font fuente = new Font();
		fuente.setStyle(Font.NORMAL);
		fuente.setSize(11);
		pdf.add(new Paragraph("\n"));

		BufferedReader br = new BufferedReader(new FileReader(qFichero));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			Paragraph para = new Paragraph(strLine + "\n", fuente);
			para.setAlignment(Element.ALIGN_JUSTIFIED);
			pdf.add(para);

		}

		pdf.close();
		br.close();
	}

}
