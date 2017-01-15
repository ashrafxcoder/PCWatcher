
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ashraf-XCODER
 */
public class WatsAppTextRemover {

    public static void main(String[] args) {
    }
}

class PdfFileVisitor extends SimpleFileVisitor<Path> {

    PrintWriter writer;

    PdfFileVisitor(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".pdf")) {

            writer.println(file.toAbsolutePath());

            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

}
