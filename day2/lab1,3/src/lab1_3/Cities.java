/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_3;

/**
 *
 * @author melsh
 */
public class Cities {
    private String city;
    private String country_id;
    private String capital;
    private String continent;
    private Double population;
    
    public Cities(String city ,String country_id , Double population,String capital,String continent){
    this.city = city;
    this.country_id = country_id;
    this.population= population ;
    this.capital= capital ;
    this.continent= continent ;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCity() {
	return city;
    }
    public void setCity(String city) {
	this.city = city;
    }


    public String getCountry_id() {
	return country_id;
    }
    public void setCountry_id(String country_id) {
	this.country_id = country_id;
    }



    public void setPopulation(double population) {
	this.population= population;
    }
    public double getPopulation() {
	return this.population;
    }

    @Override
    public String toString() {
        return "Cities{" + "city=" + city + ", country_id=" + country_id + ", capital=" + capital + ", continent=" + continent + ", population=" + population + '}';
    }


    


   
    
}