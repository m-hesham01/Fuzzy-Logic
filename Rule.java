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

        systemVars = V;

        // matching variables
        for (int i = 0; i < systemVars.size(); i++) {
            if (firstInVarName.equals(systemVars.get(i).getName())) {
                firstInVar = systemVars.get(i);
            }
        }
        for (int i = 0; i < systemVars.size(); i++) {
            if (secondInVarName.equals(systemVars.get(i).getName())) {
                secondInVar = systemVars.get(i);
            }
        }
        for (int i = 0; i < systemVars.size(); i++) {
            if (outVarName.equals(systemVars.get(i).getName())) {
                outVar = systemVars.get(i);
            }
        }

        // matching fuzzy sets within variables
        for (int j = 0; j < firstInVar.getFuzzySets().size(); j++){
            if (firstVarSetName.equals(firstInVar.getFuzzySets().get(j).getName())){
                firstVarSet = firstInVar.getFuzzySets().get(j);
            }
        }
        for (int j = 0; j < secondInVar.getFuzzySets().size(); j++){
            if (secondVarSetName.equals(secondInVar.getFuzzySets().get(j).getName())){
                secondVarSet = secondInVar.getFuzzySets().get(j);
            }
        }
        for (int j = 0; j < outVar.getFuzzySets().size(); j++){
            if (outVarSetName.equals(outVar.getFuzzySets().get(j).getName())){
                outVarSet = outVar.getFuzzySets().get(j);
            }
        }

        this.operator = operator;

    }

    public Variable getFirstInVar() {
        return firstInVar;
    }

    public void setFirstInVar(Variable firstInVar) {
        this.firstInVar = firstInVar;
    }

    public Variable getSecondInVar() {
        return secondInVar;
    }

    public void setSecondInVar(Variable secondInVar) {
        this.secondInVar = secondInVar;
    }

    public Variable getOutVar() {
        return outVar;
    }

    public void setOutVar(Variable outVar) {
        this.outVar = outVar;
    }

    public FuzzySet getFirstVarSet() {
        return firstVarSet;
    }

    public void setFirstVarSet(FuzzySet firstVarSet) {
        this.firstVarSet = firstVarSet;
    }

    public FuzzySet getSecondVarSet() {
        return secondVarSet;
    }

    public void setSecondVarSet(FuzzySet secondVarSet) {
        this.secondVarSet = secondVarSet;
    }

    public FuzzySet getOutVarSet() {
        return outVarSet;
    }

    public void setOutVarSet(FuzzySet outVarSet) {
        this.outVarSet = outVarSet;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
