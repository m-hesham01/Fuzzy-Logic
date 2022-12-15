import java.util.ArrayList;

public abstract class Defuzzifier {

    //calculates the crisp value of an output variable according to membersship values to its fuzzy sets
    public static ArrayList<Variable> defuzzifyOutput(ArrayList<Variable> tempVariables){
        for (Variable v : tempVariables){
            if (v.getType() == false){      //ensures it's an output variable
                float sumNum = 0;
                float sumMemb = 0;

                //using the weighted average method
                for (int i = 0; i < v.getFuzzySets().size(); i++){
                    sumNum += v.getFuzzySets().get(i).getCentroid() * v.getFuzzySets().get(i).getMembership();
                    sumMemb += v.getFuzzySets().get(i).getMembership();
                }
                float tempCrisp = (sumNum/sumMemb); 
                v.setCrispValue(tempCrisp);
            }
        }
        return tempVariables;
    }
}
