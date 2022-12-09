import java.io.FileNotFoundException;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {

        Parser parser = new Parser("input2.txt");
        FuzzySystem fuzzySystem = new FuzzySystem("Project Risk Estimation", "This is a test fuzzy system",parser);
        fuzzySystem.fuzzifyInput();
        fuzzySystem.infer();
        fuzzySystem.defuzzify();

        //output
        for (int i = 0; i < fuzzySystem.getSystemVariables().size(); i++){
            if(fuzzySystem.getSystemVariables().get(i).getType() == true){
                System.out.println("The crisp value for the INPUT variable " + fuzzySystem.getSystemVariables().get(i).getName() + " is " + fuzzySystem.getSystemVariables().get(i).getCrispValue());
                System.out.println("The membership values to its fuzzy sets:");
                for (int j = 0; j < fuzzySystem.getSystemVariables().get(i).getFuzzySets().size(); j++){
                    System.out.println(fuzzySystem.getSystemVariables().get(i).getFuzzySets().get(j).getName() + ": " + fuzzySystem.getSystemVariables().get(i).getFuzzySets().get(j).getMembership());
                }
                System.out.println();
            }
            else{
                System.out.println("The crisp value for the OUTPUT variable " + fuzzySystem.getSystemVariables().get(i).getName() + " is " + fuzzySystem.getSystemVariables().get(i).getCrispValue());
                System.out.println("The membership values to its fuzzy sets:");
                for (int j = 0; j < fuzzySystem.getSystemVariables().get(i).getFuzzySets().size(); j++){
                    System.out.println(fuzzySystem.getSystemVariables().get(i).getFuzzySets().get(j).getName() + ": " + fuzzySystem.getSystemVariables().get(i).getFuzzySets().get(j).getMembership());
                }
                System.out.println();
            }
        }
    }
}
