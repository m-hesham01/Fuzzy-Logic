import java.util.ArrayList;

public abstract class Defuzzifier {
    public static FuzzySystem defuzzifyOutput(FuzzySystem s){
        ArrayList<Variable> tempVariables = new ArrayList<>();
        tempVariables = s.getSystemVariables();
        for (Variable v : tempVariables){
            if (v.getType() == false){
                float sumNum = 0;
                float sumMemb = 0;
                for (int i = 0; i < v.getFuzzySets().size(); i++){
                    sumNum += v.getFuzzySets().get(i).getCentroid() * v.getFuzzySets().get(i).getMembership();
                    sumMemb += v.getFuzzySets().get(i).getMembership();
                }
                float tempCrisp = (sumNum/sumMemb); 
                v.setCrispValue(tempCrisp);
            }
        }
        s.setSystemVariables(tempVariables);
        return s;
    }
}
