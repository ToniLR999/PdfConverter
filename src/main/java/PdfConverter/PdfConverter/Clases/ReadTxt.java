package PdfConverter.PdfConverter.Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTxt {
	
	public static void LeerTxt(String qFichero) {
		File f;
		FileReader fr;
		BufferedReader in;
		
		f = new File(qFichero);
		try {
			fr = new FileReader(f);
			in = new BufferedReader(fr);
			
			while(in.ready()) {
				System.out.println(in.readLine());
			}
		} catch (IOException e) {
			System.err.println("No puedo leer el fichero");
			//e.printStackTrace();
		}
		
	}

}
