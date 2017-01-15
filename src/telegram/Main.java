/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegram;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ashraf-XCODER
 */
public class Main {
    public static void main(String[] args) throws Exception {
        PhoneFormat format = PhoneFormat.getInstance();
        HashMap<String, ArrayList<String>> callingCode = format.getCallingCodeCountries();
        HashMap<String, CallingCodeInfo> callingInfo = format.getCallingCodeInfo();
        HashMap<String, String> countryCallingCode = format.getCountryCallingCode();
        //System.out.println(callingInfo.toString());
        
//        for(String key : callingInfo.keySet()){
//            System.out.println(callingInfo.get(key).countries);
//            System.out.println(callingInfo.keySet().size());
//            
//        }
        
//        callingCode.forEach((k, v) -> {
//            System.out.print("Key is: " + k + " : ");
//            v.forEach(c -> {
//                System.out.print(" " + c + " ");
//            });
//            System.out.println("");
//        });
        
        
        System.out.println(getHexBytes("AShraF"));
    }
    
    
    
        private static String getHexBytes(String s) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {

            int a = s.charAt(i);
            int b1 = (a >>8) & 0xff;
            int b2 = (byte)a;
            int b11 = (b1>>4) & 0x0f;
            int b12 = b1 & 0x0f;
            int b21 = (b2 >>4) & 0x0f;
            int b22 = b2 & 0x0f;

            sb.append(Integer.toHexString(b11));
            sb.append(Integer.toHexString(b12));
            sb.append(Integer.toHexString(b21));
            sb.append(Integer.toHexString(b22));
            sb.append(' ');
        }
        return sb.toString();
    }
}
