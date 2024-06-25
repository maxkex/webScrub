package fileIO;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
public class OCR {
    public static void main( String[] args ) throws InterruptedException{
        // Specify the path to the Tesseract executable
        String tesseractPath = "/opt/homebrew/bin/tesseract";
        // Create a new instance of the Tesseract OCR engine
        Tesseract tesseract = new Tesseract();
        File imageFile = new File("/Users/qarnd/Downloads/screenshot_20240514203439.png");
        System.out.println("image file path: " + imageFile.getAbsolutePath());
        
        tesseract.setDatapath(tesseractPath);
        try {
            // Perform OCR on the image

            String result = tesseract.doOCR(imageFile);

            // Print the OCR result
            System.out.println(result);
        } catch (TesseractException e) {
            // Handle any errors that occur during OCR
            e.printStackTrace();
        }
    }
} 
