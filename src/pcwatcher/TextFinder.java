///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pcwatcher;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.URL;
//import java.net.URLClassLoader;
//import java.nio.file.FileVisitResult;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.SimpleFileVisitor;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Stream;
//import javax.tools.Diagnostic;
//import javax.tools.DiagnosticCollector;
//import javax.tools.JavaCompiler;
//import javax.tools.JavaFileObject;
//import javax.tools.StandardJavaFileManager;
//import javax.tools.ToolProvider;
//
///**
// * countries.tsv
// *
// * @author Ashraf-XCODER
// */
//public class TextFinder {
//
//    public static void main(String[] args) throws Exception {
//
//        //ClassLoader classLoader = new URLClassLoader();
//        ClassLoader loader = ClassLoader.getSystemClassLoader();
//        Class cc = loader.loadClass("");
//        /**
//         * Compilation Requirements ********************************************************************************************
//         */
//        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
//
//                // This sets up the class path that the compiler will use.
//        // I've added the .jar file that contains the DoStuff interface within in it...
//        List<String> optionList = new ArrayList<String>();
//        optionList.add("-classpath");
//        optionList.add(System.getProperty("java.class.path") + ";dist/InlineCompiler.jar");
//
//        Iterable<? extends JavaFileObject> compilationUnit
//                = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(helloWorldJava));
//        JavaCompiler.CompilationTask task = compiler.getTask(
//                null,
//                fileManager,
//                diagnostics,
//                optionList,
//                null,
//                compilationUnit);
//        /**
//         * *******************************************************************************************
//         * Compilation Requirements *
//         */
//        if (task.call()) {
//            /**
//             * Load and execute ************************************************************************************************
//             */
//            System.out.println("Yipe");
//                    // Create a new custom class loader, pointing to the directory that contains the compiled
//            // classes, this should point to the top of the package structure!
//            URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("./").toURI().toURL()});
//            // Load the class from the classloader by name....
//            Class<?> loadedClass = classLoader.loadClass("testcompile.HelloWorld");
//            // Create a new instance...
//            Object obj = loadedClass.newInstance();
//            // Santity check
//            if (obj instanceof DoStuff) {
//                // Cast to the DoStuff interface
//                DoStuff stuffToDo = (DoStuff) obj;
//                // Run it baby
//                stuffToDo.doStuff();
//            }
//            /**
//             * ***********************************************************************************************
//             * Load and execute *
//             */
//        } else {
//            for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
//                System.out.format("Error on line %d in %s%n",
//                        diagnostic.getLineNumber(),
//                        diagnostic.getSource().toUri());
//            }
//        }
//        fileManager.close();
//    }
//    catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException exp
//
//    
//        ) {
//                exp.printStackTrace();
//    }
//
////        File cDrive = new File("G:\\Android\\Projects\\Watsapp\\src");
////        Path c = Paths.get(cDrive.toURI());
////
////        FileOutputStream fos = new FileOutputStream("JavaFilesFromGDrive.txt");
////        PrintWriter writer = new PrintWriter(fos);
////        Files.walkFileTree(c, new JavaFileVisitor(writer));
////
////        fos.close();
//}
//
//
//}
//
//class JavaFileVisitor extends SimpleFileVisitor<Path> {
//
//    static int c = 0;
//    PrintWriter writer;
//
//    JavaFileVisitor(PrintWriter writer) {
//        this.writer = writer;
//    }
//
//    @Override
//    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//
//        if (file.toString().endsWith(".java") || file.toString().endsWith(".xml")) {
//
//            Stream<String> lines = Files.lines(file);
//
//            lines.forEach(l -> {
//                if (l.contains("countries")) {
//                    writer.println(file.toAbsolutePath());
//                    System.out.println(file.getFileName());
//                    System.out.println(file.toAbsolutePath());
//                }
//                //System.out.println(l);
//            });
//        }
//        return FileVisitResult.CONTINUE;
//    }
//
//    @Override
//    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//        return FileVisitResult.CONTINUE;
//    }
//
//}
