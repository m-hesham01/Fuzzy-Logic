import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        FuzzySystem testSystem = new FuzzySystem("Project Risk Estimation", "This is a test fuzzy system");

        ArrayList<Variable> V = new ArrayList<> ();
        Variable var1 = new Variable("proj_funding", true, 0, 100, 4);
        Variable var2 = new Variable("exp_level", true, 0, 60, 3);
        Variable var3 = new Variable("risk", false, 0, 100, 3);

        ArrayList<FuzzySet> fundFuz = new ArrayList<>();
        int[] fundArr1 = new int[] { 0, 0, 10, 30 };
        int[] fundArr2 = new int[] { 10, 30, 40, 60 };
        int[] fundArr3 = new int[] { 40, 60, 70, 90 };
        int[] fundArr4 = new int[] { 70, 90, 100, 100 };
        FuzzySet fuz1 = new FuzzySet("very_low", "trap", fundArr1);
        FuzzySet fuz2 = new FuzzySet("low", "trap", fundArr2);
        FuzzySet fuz3 = new FuzzySet("medium", "trap", fundArr3);
        FuzzySet fuz4 = new FuzzySet("high", "trap", fundArr4);
        fundFuz.add(fuz1);
        fundFuz.add(fuz2);
        fundFuz.add(fuz3);
        fundFuz.add(fuz4);
        var1.setFuzzySets(fundFuz);

        ArrayList<FuzzySet> expFuz = new ArrayList<>();
        int[] expArr1 = new int[] { 0, 15, 30 };
        int[] expArr2 = new int[] { 15, 30, 45 };
        int[] expArr3 = new int[] { 30, 60, 60 };
        FuzzySet fuz5 = new FuzzySet("beginner", "tri", expArr1);
        FuzzySet fuz6 = new FuzzySet("intermediate", "tri", expArr2);
        FuzzySet fuz7 = new FuzzySet("expert", "tri", expArr3);
        expFuz.add(fuz5);
        expFuz.add(fuz6);
        expFuz.add(fuz7);
        var2.setFuzzySets(expFuz);

        ArrayList<FuzzySet> riskFuz = new ArrayList<>();
        int[] riskArr1 = new int[] { 0, 25, 50 };
        int[] riskArr2 = new int[] { 25, 50, 75 };
        int[] riskArr3 = new int[] { 50, 100, 100 };

        FuzzySet fuz8 = new FuzzySet("low", "tri", riskArr1);
        FuzzySet fuz9 = new FuzzySet("normal", "tri", riskArr2);
        FuzzySet fuz10 = new FuzzySet("high", "tri", riskArr3);
        riskFuz.add(fuz8);
        riskFuz.add(fuz9);
        riskFuz.add(fuz10);
        var3.setFuzzySets(riskFuz);

        var1.setCrispValue(50);
        var2.setCrispValue(40);

        V.add(var1);
        V.add(var2);
        V.add(var3);

        ArrayList<Rule> R = new ArrayList<>();
        Rule r1 = new Rule("proj_funding", "high", "or", "exp_level", "expert", "risk", "low", V);
        Rule r2 = new Rule("proj_funding", "medium", "and", "exp_level", "intermediate", "risk", "normal", V);
        Rule r3 = new Rule("proj_funding", "medium", "and", "exp_level", "beginner", "risk", "normal", V);
        Rule r4 = new Rule("proj_funding", "low", "and", "exp_level", "beginner", "risk", "high", V);
        Rule r5 = new Rule("proj_funding", "very_low", "and_not", "exp_level", "expert", "risk", "high", V);
        R.add(r1);
        R.add(r2);
        R.add(r3);
        R.add(r4);
        R.add(r5);

        ArrayList<Variable> outVar = new ArrayList<>();
        outVar.add(var3);

        testSystem.setSystemVariables(V);
        testSystem.setSystemRules(R);

        testSystem.outputVars = outVar;

        testSystem = Fuzzifier.calculateMembership(testSystem);       
        testSystem = Inference.applyRules(testSystem);


        //testing fuzzifier
        for (int i = 0; i < testSystem.getSystemVariables().size(); i++){
            System.out.println("The crisp value for the variable " + testSystem.getSystemVariables().get(i).getName() + " is " + testSystem.getSystemVariables().get(i).getCrispValue());
            System.out.println("The membership values to its fuzzy sets:");
                    for (int j = 0; j < testSystem.getSystemVariables().get(i).getFuzzySets().size(); j++){
                        System.out.println(testSystem.getSystemVariables().get(i).getFuzzySets().get(j).getName() + ": " + testSystem.getSystemVariables().get(i).getFuzzySets().get(j).getMembership());
                    }
                    System.out.println();
        }

        // Defuzzifier.calcCentroids(testSystem);
    }
}