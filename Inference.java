import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class Inference {
    private float calcRule(Rule r){
        float result = -1;
        switch(r.operator){
            case "or":
                result = Math.max(r.firstVarSet.membership,r.secondVarSet.membership);
                return result;
            
            case "and":
                result = Math.min(r.firstVarSet.membership,r.secondVarSet.membership);
                return result;
            
            case "and_not":
                float min = Math.min(r.firstVarSet.membership,r.secondVarSet.membership);
                result = 1-min; 
                return result;
            
            case "or_not":
                float max = Math.max(r.firstVarSet.membership,r.secondVarSet.membership);
                result = 1-max; 
                return result; 

            default:
                System.out.println("Error: Unknown operator");;
        }
        return result;
    }

    public int applyRules(FuzzySystem s){
        int maxRuleIndex  = 0;
        ArrayList<Rule> systemRules =  s.getSystemRules();
        float [] ruleResults = new float [systemRules.size()]; ;
        for (int i = 0; i < systemRules.size(); i++) { //loop over all rules
            Rule tempRule = systemRules.get(i);
            ruleResults[i] = calcRule(tempRule);
        }
        for(int i = 0; i < ruleResults.length-1; i++) {  //get max 
            if(ruleResults[i+1] > ruleResults[i]){
                maxRuleIndex = i+1;
            }
        }
        return maxRuleIndex;
    }
}
