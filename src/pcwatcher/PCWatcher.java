///*
// program tech url
// ------------------
// class = title-text
// id    = publisher-licence-details
// class = program-header-author
// class = program-header-licence
// ***********************************
// description page
// id= program-description-text-column (all p inside this class remove any div and a tag inside this class)
//
//
// */
//package pcwatcher;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.nio.file.FileSystems;
//import java.nio.file.FileVisitResult;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.SimpleFileVisitor;
//import java.nio.file.StandardWatchEventKinds;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.nio.file.spi.FileTypeDetector;
//import java.util.ServiceLoader;
//import java.util.stream.Stream;
//import static java.nio.file.StandardWatchEventKinds.*;
//import java.nio.file.WatchEvent;
//import java.nio.file.WatchKey;
//import java.nio.file.WatchService;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//
//
//);
///**
// *
// * @author Ashraf-XCODER
// */
//public class PCWatcher {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws Exception {
//
//        Path path = Paths.get("d:");
//        WatchService watchService = FileSystems.getDefault().newWatchService();
//        WatchKey watchKey = path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
//
//        boolean notDone = true;
//        while (notDone) {
//            try {
//                WatchKey watchKey1 = watchService.poll(60, TimeUnit.SECONDS);
//                List<WatchEvent<?>> events = watchKey1.pollEvents();
//                for (WatchEvent<?> event : events) {
//                    //...process the events
//                    //WatchKey watchable returns the calling Path object of Path.register
//                    Path watchedPath = (Path) watchKey.watchable();
//                    //returns the event type
//                    WatchEvent.Kind<?> eventKind = event.kind();
//                    //returns the context of the event
//                    Path target = (Path) event.context();
//
//                }
//                if (!watchKey.reset()) {
//                    //...handle situation no longer valid
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//
////        File file = new File(".");
////
////        Files.walk(Paths.get(file.toURI()))
////                .filter(Files::isRegularFile)
////                .forEach(System.out::println);
//            File cDrive = new File("G:\\");
//            Path c = Paths.get(cDrive.toURI());
//
//            FileOutputStream fos = new FileOutputStream("PdfFilesFromGDrive.txt", true);
//            PrintWriter writer = new PrintWriter(fos);
//            Files.walkFileTree(c, new PCWatcher.PdfFileVisitor(writer));
//
//            fos.close();
//
//            Stream<String> lines = Files.lines(c);
//            Stream<Path> pathsToFiles = Files.list(c);
//            BufferedReader reader = Files.newBufferedReader(c);
//            //Files.
//            FileTypeDetector dectector = new FileTypeDetector() {
//
//                @Override
//                public String probeContentType(Path path) throws IOException {
//                    return "";
//                }
//            };
//            String contentType = dectector.probeContentType(c);
//            ServiceLoader loader;
//
//            Files.readAllLines(c);
//            Files.probeContentType(c);
//
//        }
//    }
//
//    static class PdfFileVisitor extends SimpleFileVisitor<Path> {
//
//        PrintWriter writer;
//
//        PdfFileVisitor(PrintWriter writer) {
//            this.writer = writer;
//        }
//
//        @Override
//        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//            if (file.toString().endsWith(".pdf")) {
//
//                writer.println(file.toAbsolutePath());
//
//                System.out.println(file.getFileName());
//            }
//            return FileVisitResult.CONTINUE;
//        }
//
//        @Override
//        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//            return FileVisitResult.CONTINUE;
//        }
//
//    }
//
//    private void registerDirectories(Path startPath) throws IOException {
//        Files.walkFileTree(startPath, new WatchServiceRegisteringVisitor());
//    }
//
//    private class WatchServiceRegisteringVisitor extends SimpleFileVisitor<Path> {
//
//        WatchService watchService;
//
//        @Override
//        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//            dir.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
//            return FileVisitResult.CONTINUE;
//        }
//    }
//}