/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;
import javax.swing.JFrame;

/**
 *
 * @author Ashraf-XCODER
 */
public class JFrameTest {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
        JFrame f;
        long start, end;

        start = System.currentTimeMillis();
        f = new JFrame("JFrame");
        end = System.currentTimeMillis();

        System.out.println("JFrame first creation took " + (end - start) + " ms");

        start = System.currentTimeMillis();
        f = new JFrame("JFrame");
        end = System.currentTimeMillis();

        System.out.println("JFrame second creation took " + (end - start) + " ms");
        System.exit(0);        
        
    }

    private static void checkUUID() throws IOException, RuntimeException, ClassNotFoundException {
        UUID a = UUID.randomUUID();
        System.out.println(a);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(a);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        UUID b = (UUID)ois.readObject();
        if (!a.equals(b))
            throw new RuntimeException("UUIDs not equal");
        System.out.println(b);
        oos.close();
        ois.close();
    }
}
