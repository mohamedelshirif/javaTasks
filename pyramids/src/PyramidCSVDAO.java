
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author melsh
 */

public class PyramidCSVDAO{
    List<Pyramid> pyramids;

    public List<Pyramid> readPyramidFromCSV(String rawFileName){
        pyramids = new ArrayList<>();
        File pyramidFile = new File(rawFileName);
        List<String> lines = new ArrayList<>();
        try {   
            lines = Files.readAllLines(pyramidFile.toPath());
        } catch (IOException e){
           System.out.println(e);
        }
        
        for (int lineIdx =1 ;lineIdx <lines.size();lineIdx++) {
            String line = lines.get(lineIdx);
            String[] fields = line.split(",");
            for (int i=0; i<fields.length; i++) {
                fields[i] = fields[i].trim();
            }
            Pyramid pyramid = createPyramid(fields);
            pyramids.add(pyramid);
        }
        return pyramids;
}
    public Pyramid createPyramid(String [] metadata){
        String pharoah = metadata[0];
	String modern_name=metadata[2];
	String site = metadata[4];
	double height;
            try {
                    height = Double.parseDouble(metadata[7]); //Convert height from string to double to match Pyramid class constructor.
		} catch(Exception e) {
			height = 0;
		}
		
		
	return new Pyramid(pharoah, modern_name, site, height);
    }
}	
	
		
		