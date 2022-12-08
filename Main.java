import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {

        Parser parser = new Parser("input sample.txt");
        FuzzySystem fuzzySystem = new FuzzySystem("Project Risk Estimation", "This is a test fuzzy system",parser);
        fuzzySystem = Fuzzifier.calculateMembership(fuzzySystem);
        fuzzySystem = Inference.applyRules(fuzzySystem);
        fuzzySystem = Defuzzifier.defuzzifyOutput(fuzzySystem);

        //output
        for (int i = 0; i < fuzzySystem.getSystemVariables().size(); i++){
            System.out.println("The crisp value for the variable " + fuzzySystem.getSystemVariables().get(i).getName() + " is " + fuzzySystem.getSystemVariables().get(i).getCrispValue());
            System.out.println("The membership values to its fuzzy sets:");
            for (int j = 0; j < fuzzySystem.getSystemVariables().get(i).getFuzzySets().size(); j++){
                System.out.println(fuzzySystem.getSystemVariables().get(i).getFuzzySets().get(j).getName() + ": " + fuzzySystem.getSystemVariables().get(i).getFuzzySets().get(j).getMembership());
            }
            System.out.println();
        }
    }
}
