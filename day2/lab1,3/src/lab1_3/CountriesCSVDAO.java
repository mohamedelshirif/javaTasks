/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melsh
 */
public class CountriesCSVDAO {

    List<Countries> countries;
    public CountriesCSVDAO(String rawFileName){
        this.countries = new ArrayList<>();
        File CountriesFile = new File(rawFileName);
        List<String> lines = new ArrayList<>();
        try {   
            lines = Files.readAllLines(CountriesFile.toPath());
        } catch (IOException e){
           System.out.println(e);
        }
        for (int lineIdx =1 ;lineIdx <lines.size();lineIdx++) {
            String line = lines.get(lineIdx);
            String[] fields = line.split(",");
            for (int i=0; i<fields.length; i++) {
                fields[i] = fields[i].trim();
            }
            Countries country = new Countries(fields[0],fields[1]);
            countries.add(country);
	}
}    
}
