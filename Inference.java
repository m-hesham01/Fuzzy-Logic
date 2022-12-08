import java.util.ArrayList;

public abstract class Inference {
    private static float calcRule(Rule r) {
        float result = -1;
        switch (r.operator) {
            case "or":
                result = Math.max(r.firstVarSet.membership, r.secondVarSet.membership);
                return result;

            case "and":
                result = Math.min(r.firstVarSet.membership, r.secondVarSet.membership);
                return result;

            case "and_not":
                float tempNot = 1 - r.secondVarSet.membership;
                result = Math.min(r.firstVarSet.membership, tempNot);
                return result;

            case "or_not":
                float tempNot2 = 1 - r.secondVarSet.membership;
                result = Math.max(r.firstVarSet.membership, tempNot2);
                return result;

            default:
                System.out.println("Error: Unknown operator");
                ;
        }
        return result;
    }

    public static void applyRules(FuzzySystem s) {
        ArrayList<Rule> systemRules = s.getSystemRules();
        for (int i = 0; i < systemRules.size(); i++) { // loop over all rules
            Rule tempRule = systemRules.get(i);
            tempRule.outVarSet.membership = calcRule(tempRule);
            System.out.println(tempRule.outVarSet.membership);
        }
    }
}
