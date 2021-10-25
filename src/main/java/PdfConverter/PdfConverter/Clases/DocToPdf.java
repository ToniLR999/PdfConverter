package PdfConverter.PdfConverter.Clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

public class DocToPdf {

	public static void ConvertDoc(String qFichero) {

		String k = null;
		FileOutputStream fileForPdf = null;
		try {

			String fileName = qFichero;

			if (fileName.endsWith(".doc")) {
				HWPFDocument doc = new HWPFDocument(new FileInputStream(fileName));
				WordExtractor we = new WordExtractor(doc);
				k = we.getText();

				fileForPdf = new FileOutputStream(new File("src/main/java/resources/DocToPdf.pdf"));
				
			}

			else if (fileName.endsWith(".docx")) {
				XWPFDocument docx = new XWPFDocument(new FileInputStream(fileName));
				// using XWPFWordExtractor Class
				XWPFWordExtractor we = new XWPFWordExtractor(docx);
				k = we.getText();

				fileForPdf = new FileOutputStream(new File("src/main/java/resources/DocxToPdf.pdf"));
				we.close();
			}

			Document document = new Document();
			PdfWriter.getInstance(document, fileForPdf);

			document.open();

			document.add(new Paragraph(k));

			document.close();
			fileForPdf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
