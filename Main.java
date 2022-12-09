import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {

        Parser parser = new Parser("input2.txt");
        FuzzySystem fuzzySystem = new FuzzySystem("Test System", "This is a test fuzzy system", parser);
        fuzzySystem.fuzzifyInput();
        fuzzySystem.infer();
        fuzzySystem.defuzzify();
        fuzzySystem.determineOutputs();

        //output
        try {
            fuzzySystem.produceOutput("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fuzzySystem.produceGraphFile("graph.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
