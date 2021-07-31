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
public class CitiesCSVDAO {

    List<Cities> cities; 
    public List<Cities> readCitiesFromCSV(String rawFileName){
        cities = new ArrayList<>();
        File citiesFile = new File(rawFileName);
        List<String> lines = new ArrayList<>();
        try {   
            lines = Files.readAllLines(citiesFile.toPath());
        } catch (IOException e){
           System.out.println(e);
        }
        
        for (int lineIdx =1 ;lineIdx <lines.size();lineIdx++) {
            String line = lines.get(lineIdx);
            String[] fields = line.split(",");
            for (int i=0; i<fields.length; i++) {
                fields[i] = fields[i].trim();
            }
            Cities city = createcities(fields);
            cities.add(city);
        }
        return cities;
}
    public Cities createcities(String [] metadata){
        String city = metadata[1];
	String country_Id=metadata[2];
	String capital=metadata[3];
        String continent=metadata[5];
	double population;
            try {
                    population = Double.parseDouble(metadata[4]);
		} catch(Exception e) {
			population = 0;
		}
		
		
	return new Cities(city, country_Id,population, capital, continent);
    }
    
        
        
}