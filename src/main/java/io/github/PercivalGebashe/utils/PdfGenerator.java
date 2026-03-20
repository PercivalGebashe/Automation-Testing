package io.github.PercivalGebashe.utils;

import java.io.*;
import java.nio.file.Files;

public class PdfGenerator {

//    public static void generatePdf(String htmlPath, String pdfPath) {
//        try {
//            File htmlFile = new File(htmlPath);
//
//            if (!htmlFile.exists()) {
//                System.out.println("HTML report not found: " + htmlPath);
//                return;
//            }
//
//            String htmlContent = Files.readString(htmlFile.toPath());
//
//            try (OutputStream os = new FileOutputStream(pdfPath)) {
//                PdfRendererBuilder builder = new PdfRendererBuilder();
//
//                builder.withHtmlContent(htmlContent, htmlFile.toURI().toString());
//                builder.toStream(os);
//                builder.run();
//
//                System.out.println("PDF generated at: " + pdfPath);
//            }
//
//        } catch (Exception e) {
//            System.out.println("PDF generation failed");
//            e.printStackTrace();
//        }
//    }
}