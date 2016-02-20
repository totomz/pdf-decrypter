package com.github.totomz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Arrays;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;


public class PDFDecrypter {

	
	private static final File dir = new File("./input"); 
	private static final File output = new File("./output");
	
	public static void main(String[] args) {
		
		if(!output.exists()){
			output.mkdirs();
		}

		System.out.println("Looking for inputs in "+dir.getAbsolutePath());
		
		String files[] = dir.list(new FilenameFilter() {
	        public boolean accept(File dir, String name) {
	        	return name.endsWith(".pdf");
	        }
	    });

		if(files == null || files.length == 0) {
			System.out.println("No input files found! Quitting");
			System.exit(1);
		}
		
	    Arrays.stream(files).forEach(PDFDecrypter::decryptFile);
	    
		System.out.println("Done!");
	}
	
	
	public static boolean decryptFile(String file) {

		PdfReader reader = null;
		Document document = null;
		
		System.out.println("Decrypting " + file);
		
		try {
			
			reader = new PdfReader("./input/"+file);
			document = new Document(reader.getPageSize(1));
					
			PdfCopy copy = new PdfCopy(document, new FileOutputStream("./output/"+file));
			
			document.open();
			int nPages = reader.getNumberOfPages();
			for(int i = 1;i<=nPages;i++) {
				PdfImportedPage page = copy.getImportedPage(reader, i);
				copy.addPage(page);				
			}						
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(reader != null)
				reader.close();
			if(document != null)
				document.close();
		}
		
		return true;
	}
	

}
