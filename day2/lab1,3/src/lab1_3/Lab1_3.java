/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_3;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author melsh
 */
public class Lab1_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CitiesCSVDAO pDAO = new CitiesCSVDAO();
		List<Cities> city = pDAO.readCitiesFromCSV("C:\\Users\\melsh\\OneDrive\\Desktop\\java\\cities.csv");

        CountriesCSVDAO pDAO2 = new CountriesCSVDAO("C:\\Users\\melsh\\OneDrive\\Desktop\\java\\countries.csv");
		List<Countries> countries = pDAO2.countries;

        Map <String,List<Cities>> cityMap = new HashMap() ;
        for (int i=0 ;i<countries.size();i++){
            String s = countries.get(i).getCountry_id();
            List<Cities>  cityToAppend = new ArrayList<>();
            for (int j=0 ;j<city.size();j++){
            if (city.get(j).getCountry_id().equals(s))
            { cityToAppend.add(city.get(j));}        
            }
            cityMap.put(s,cityToAppend);
        }

        cityMap.forEach((k, v) ->{v= v.stream().sorted(Comparator.comparing(Cities::getPopulation)).collect(Collectors.toList());
                cityMap.replace(k, v);});

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    Map<String,Cities> highestPopulationCountry = new HashMap<>();
    cityMap.forEach((k,v)-> highestPopulationCountry.put(k, v.stream().reduce((c1,c2)-> c1.getPopulation()>= c2.getPopulation() ? c1 : c2).get()));

//    System.out.println("Highest population city of each country : "+highestPopulationCountry);

    Map<String,Cities> highestPopulationContinent = new HashMap<>();
    for (int i=0 ;i<city.size();i++){
        String c = city.get(i).getContinent();
        if(highestPopulationContinent.get(c) != null){
            if(city.get(i).getPopulation() > highestPopulationContinent.get(c).getPopulation()){
                highestPopulationContinent.put(c, city.get(i));}
        }else{highestPopulationContinent.put(c, city.get(i));} 
    }
//    System.out.println("Highest population city by continent : "+highestPopulationContinent); 
    
     Cities capitals= city.stream().filter(c->c.getCapital().equals("primary"))
             .max((c1,c2)-> (int) Math.round(c1.getPopulation()) - (int) Math.round(c2.getPopulation())).get();
											  
    System.out.println("Highest population city by capital : "+capitals);  
}
}
