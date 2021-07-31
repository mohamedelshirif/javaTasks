/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mansourag2.day3task1;

/**
 *
 * @author melsh
 */


import java.io.IOException;
import java.util.List;
import joinery.DataFrame;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

public class JoineryTableSawDataFrame {
    public static void main(String args[]){
        try {
            DataFrame<Object>  df= DataFrame.readCsv ("src/main/resources/data/titanic.csv");
            DataFrame<Object>  df2= DataFrame.readCsv ("src/main/resources/data/titanic.csv");

            System.out.println(df.describe());
	    System.out.println("=============================================================================================");
	    df2 = df2.retain("pclass", "survived", "name");
	    List<Object> col = df.col("sex");
	    df2.add("sex", col);
          System.out.println(df2.columns());
	    System.out.println("=============================================================================================");
	    df2 = df.retain("ticket", "survived", "name","sibsp");
	    DataFrame<Object> dfMerged = df.merge(df2);
            System.out.println(dfMerged.columns());
        } catch (IOException e) {
        }
        try {
            Table table = Table.read().csv("src/main/resources/data/titanic.csv");
            Table table2 = Table.read().csv("src/main/resources/data/titanic.csv");

            System.out.println(table.summary());
            System.out.println("=============================================================================================");
            table2 = table2.retainColumns("pclass", "survived", "name");
            DoubleColumn col = (DoubleColumn) table.column ("age");
            table2.insertColumn(0,col);
            System.out.println(table2.columns());
	    System.out.println("=============================================================================================");
            table2 = table.retainColumns("ticket", "survived", "name","sibsp");
	    Table dfMerged = table.append(table2);
            System.out.println(dfMerged.columns());
            	
	    } catch (IOException e) {
    }
}
}

