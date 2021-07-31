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
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		PyramidCSVDAO pDAO = new PyramidCSVDAO();
		List<Pyramid> pyramids = pDAO.readPyramidFromCSV("C:\\Users\\melsh\\OneDrive\\Desktop\\java\\pyramids.csv");
		int i =0;
		for (Pyramid p: pyramids) {
			System.out.println("#"+ (i++) + " " + p);
                }

		

List<Double> heights = pyramids.stream().map(p -> p.getHeight()).filter(height-> height !=0).sorted().collect(Collectors.toList());
		
    double median,lowerQuartile,upperQuartile;
    int m = heights.size()/2;
    if (heights.size()%2 ==0) 
    {median = (heights.get(m)+heights.get(m+1))/2;}
    else {median = heights.get(m);}

    lowerQuartile = (heights.get(m/2)+heights.get((m+1)/2))/2;
    upperQuartile = (heights.get(3*m/2)+heights.get(3*(m+1)/2))/2;
		
    System.out.println("median : " + median + " ,lower quartile : " + lowerQuartile + " ,upper quartile : " + upperQuartile);
}
}
