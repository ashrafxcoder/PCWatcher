
package worldcities;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;


public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> cities = new HashMap<>();

        String file = "G:\\city.list.json";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            for (int i = 0; i < 200000; i++) {
                String line = reader.readLine();

                JSONObject jsonObj = new JSONObject(line);
                //{"name":"Hurzuf","country":"UA","coord":{"lon":34.283333,"lat":44.549999}}

                String cityName = jsonObj.getString("name");
                String countryCode = jsonObj.getString("country");

                JSONObject coordinates = jsonObj.getJSONObject("coord");
                double lon = coordinates.getDouble("lon");
                double lat = coordinates.getDouble("lat");

                    if (cities.containsKey(countryCode)) {
                        List<String> c = cities.get(countryCode);
                        c.add(cityName);
                    } else {
                        ArrayList<String> c = new ArrayList<>();
                        c.add(cityName);
                        cities.put(countryCode, c);
                    }
                

                System.out.println(String.format("City %s  Country %s Coordinates {lat %s, lon %s}", cityName, countryCode, lat, lon));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.exit(1);
    }
}
