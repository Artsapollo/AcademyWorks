package Lesson21.abstractFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbstractFactory {
    public static void main (String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String country = reader.readLine();
        InterAbsFactory iaf = null;

        if(country.equals("UA")){
            iaf = new UaCarPrice();
        } else if (country.equals("RU")){
            iaf = new RuCarPrice();
        }

        Porshe porshe = iaf.getPorshe();
        System.out.println(porshe.getText());

        Audi audi = iaf.getAudi();
        System.out.println(audi.getText());

        Nissan nissan = iaf.getNissan();
        System.out.println(nissan.getText());
    }
}
