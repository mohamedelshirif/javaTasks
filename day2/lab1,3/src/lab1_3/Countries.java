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
public class Countries {
    private String country;
    private String country_id;
    
    public Countries(String country ,String country_id ){
    this.country = country;
    this.country_id = country_id;
    
    }

    public String getCountry() {
	return country;
    }
    public void setCountry(String country) {
	this.country = country;
    }


    public String getCountry_id() {
	return country_id;
    }
    public void setCountry_id(String country_id) {
	this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "Countries{" + "country=" + country + ", country_id=" + country_id + '}';
    }


}
