package jupai7.sm;

import smile.classification.RandomForest;
import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.data.measure.NominalScale;
import smile.data.vector.IntVector;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import smile.data.vector.StringVector;
import smile.io.Read;

public class SmileDemoEDA {
    String trainPath = "src/main/resources/data/titanic_train.csv";
    String testPath = "src/main/resources/data/titanic_test.csv";

    public static void main(String[] args) throws IOException {
        SmileDemoEDA sd = new SmileDemoEDA ();
        PassengerProvider pProvider = new PassengerProvider ();
        DataFrame trainData = pProvider.readCSV (sd.trainPath);
        System.out.println (trainData.structure ());
        trainData = trainData.merge (IntVector.of ("Gender",
                encodeCategory (trainData, "Sex")));
        trainData = trainData.merge (IntVector.of ("PClassValues",
                encodeCategory (trainData, "Pclass")));
        System.out.println ("=======Encoding Non Numeric Data==============");
        System.out.println (trainData.structure ());
        //System.out.println (trainData);
        System.out.println ("=======Dropping the Name, Pclass, and Sex Columns==============");
        trainData = trainData.drop ("Name");
        trainData=trainData.drop("Pclass");
        trainData=trainData.drop("Sex");
        System.out.println (trainData.structure ());
        System.out.println (trainData.summary ());
        trainData = trainData.omitNullRows ();
        System.out.println ("=======After Omitting null Rows==============");
        System.out.println (trainData.summary ());
        RandomForest model = RandomForest.fit(Formula.lhs("Survived"), trainData);
        System.out.println("feature importance:");
        System.out.println(Arrays.toString(model.importance()));
        System.out.println(model.metrics ());
        //TODO load test data to validate model
        DataFrame testData = sd.readTestCSV (sd.testPath);
        testData = testData.merge (IntVector.of ("Gender",
                encodeCategory (testData, "Sex")));
        testData = testData.merge(StringVector.of("pClassString",
                testData.intVector("Pclass").toStringArray()));
        testData = testData.merge (IntVector.of ("PClassValues",
                encodeCategory (testData, "pClassString")));
        testData = testData.drop ("Name");
        testData=testData.drop("Pclass");
        testData=testData.drop("Sex");
        testData=testData.drop("pClassString");
        testData = testData.omitNullRows ();
        System.out.println (testData.summary ());
       int[] result = model.predict(testData);
        for (int i:result) {
        	System.out.print(i);
    }
    }
    public static int[] encodeCategory(DataFrame df, String columnName) {
        String[] values = df.stringVector (columnName).distinct ().toArray (new String[]{});
        int[] pclassValues = df.stringVector (columnName).factorize (new NominalScale (values)).toIntArray ();
        return pclassValues;
    }
    public DataFrame readTestCSV(String path) {
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ();
        DataFrame df = null;
        try {
            df = Read.csv (path, format);
            df = df.select ("Name", "Pclass", "Age", "Sex");
            System.out.println(df.summary ());
        } catch (IOException | URISyntaxException e) {
        }
        return df;
    }

}
