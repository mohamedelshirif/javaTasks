/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author melsh
 */
public class Pyramid {
    private String pharaoh;
    private String modern_name;
    private String site;
    private Double height;
    
    public Pyramid(String pharaoh ,String modern_name ,String site, Double height){
    this.pharaoh = pharaoh;
    this.modern_name = modern_name;
    this.site=site;
    this.height=height;
    }

    public String getPharoah() {
	return pharaoh;
    }
    public void setPharoah(String pharoah) {
	this.pharaoh = pharoah;
    }


    public String getModern_name() {
	return modern_name;
    }
    public void setModern_name(String modern_name) {
	this.modern_name = modern_name;
    }


    public String getSite() {
	return site;
    }
    public void setSite(String site) {
	this.site = site;
    }


    public void setHeight(double height) {
	this.height= height;
    }
    public double getHeight() {
	return this.height;
    }
	
	@Override
    public String toString() {
	return "Pyramid [pharoah=" + pharaoh + ", modern_name=" + modern_name + ", site=" + site + ", height=" + height+ "]";
    }    
}
