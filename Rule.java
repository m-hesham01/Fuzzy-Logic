import java.util.ArrayList;

public class Rule {
    Variable firstInVar;
    Variable secondInVar;
    Variable outVar;
    FuzzySet firstVarSet;
    FuzzySet secondVarSet;
    FuzzySet outVarSet;
    String operator;
    ArrayList<Variable> systemVars = new ArrayList<>();

    public Rule(String firstInVarName, String firstVarSetName, String operator, String secondInVarName,
            String secondVarSetName, String outVarName, String outVarSetName, ArrayList<Variable> V) {
        // matching variables
        for (int i = 0; i < systemVars.size(); i++) {
            if (systemVars.get(i).getName() == firstInVarName) {
                firstInVar = systemVars.get(i);
            }
        }
        for (int i = 0; i < systemVars.size(); i++) {
            if (systemVars.get(i).getName() == secondInVarName) {
                secondInVar = systemVars.get(i);
            }
        }
        for (int i = 0; i < systemVars.size(); i++) {
            if (systemVars.get(i).getName() == outVarName) {
                outVar = systemVars.get(i);
            }
        }

        // matching fuzzy sets within variables
        for (int i = 0; i < firstInVar.getFuzzySets().size(); i++) {
            if (firstInVar.getFuzzySets().get(i).getName() == firstVarSetName) {
                firstVarSet = firstInVar.getFuzzySets().get(i);
            }
        }
        for (int i = 0; i < secondInVar.getFuzzySets().size(); i++) {
            if (secondInVar.getFuzzySets().get(i).getName() == secondVarSetName) {
                secondVarSet = secondInVar.getFuzzySets().get(i);
            }
        }
        for (int i = 0; i < outVar.getFuzzySets().size(); i++) {
            if (outVar.getFuzzySets().get(i).getName() == outVarSetName) {
                outVarSet = outVar.getFuzzySets().get(i);
            }
        }

        this.operator = operator;

    }

}
