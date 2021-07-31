/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author melsh
 */
import java.util.List;

public class Main {

	public static void main(String[] args) {
		PyramidCSVDAO pDAO = new PyramidCSVDAO();
		List<Pyramid> pyramis = pDAO.readPyramidFromCSV("C:\\Users\\melsh\\OneDrive\\Desktop\\java\\pyramids.csv");
		int i =0;
		for (Pyramid p: pyramis) {
			System.out.println("#"+ (i++) + " " + p);
                }
	}
}
