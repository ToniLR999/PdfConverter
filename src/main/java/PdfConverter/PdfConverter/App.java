package PdfConverter.PdfConverter;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import PdfConverter.PdfConverter.Clases.DocToPdf;
import PdfConverter.PdfConverter.Clases.ReadTxt;
import PdfConverter.PdfConverter.Clases.TextToPdf;

public class App 
{
    public static void main( String[] args ) throws DocumentException, IOException
    {
    	ReadTxt.LeerTxt("src/main/java/resources/fichero.txt");
		TextToPdf.TextToPdf("src/main/java/resources/fichero.txt");
    	DocToPdf.ConvertDoc("src/main/java/resources/documento.doc");
    }
}
