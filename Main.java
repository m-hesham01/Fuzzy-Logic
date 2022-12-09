import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {

        Parser parser = new Parser("input2.txt");
        FuzzySystem fuzzySystem = new FuzzySystem("Project Risk Estimation", "This is a test fuzzy system",parser);
        fuzzySystem.fuzzifyInput();
        fuzzySystem.infer();
        fuzzySystem.defuzzify();
        fuzzySystem.determineOutputs();

        //output
        try {
            fuzzySystem.produceOutput("output.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
