package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class InformatinFromWebsite {

    public InformatinFromWebsite() throws IOException {
    }
    URL olx = new URL("https://www.olx.pl/d/nieruchomosci/mieszkania/wynajem/warszawa/?search%5Bdistrict_id%5D=367&search%5Bfilter_float_price:from%5D=2000&search%5Bfilter_float_price:to%5D=3000");
    BufferedReader in = new BufferedReader(
            new InputStreamReader(olx.openStream())
    );
    String inputLine;
    StringBuilder stringBuilder = new StringBuilder();



    public void fun() throws IOException {
        while ((inputLine = in.readLine()) != null){
            stringBuilder.append(inputLine);
            stringBuilder.append(System.lineSeparator());
        }
        in.close();
        Set<String> setOfLinks = new TreeSet<>();
        String content = stringBuilder.toString();

        for (int i = 0; i < content.length(); i++){
            i = content.indexOf("d/oferta/", i);
            if (i < 0){
                break;
            }
            String substring = content.substring(i);
            String links = substring.split(".html")[0];
            links = "https://olx.pl/"+links+".html";
            setOfLinks.add(links);
        }
        setOfLinks.forEach(System.out::println);
        System.out.println(setOfLinks.size());
    }
}
