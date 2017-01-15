/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author Ashraf-XCODER
 */
public class TLRPCClassCounter {
    public static void main(String[] args) {
        
        
        //System.out.println(join());
        countLinesINTLRPC();
    }

    
    public static String join(){
        List<String> names = Arrays.asList("Tom", "Jerry", "Bob", "Jack", "Jill");
        return names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        //Comparator.comparing(null, null)
    }
    
    
    private static void countLinesINTLRPC() {
        String path = "G:\\Android\\Projects\\Telegram-master\\TMessagesProj\\src\\main\\java\\org\\telegram\\tgnet\\TLRPC.java";
        
        
        
        try(Stream<String> line = Files.lines(Paths.get(URI.create(path)))){
            
        }catch(Exception e){
            
        }
        
        
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            int counter = 0;

            String line;
            while((line = reader.readLine()) != null){
                if (line.contains("static class")) {
                    counter++;
                    
                    String className = line.substring(line.indexOf("class") + 6, line.indexOf("extends") - 1);
                    System.out.println(className);
                }
                
                
            }
            
            System.out.println("Total Nested Classes are " + counter);
            
            
            
            
        }catch(Exception ex){
            
        }
    }
}
