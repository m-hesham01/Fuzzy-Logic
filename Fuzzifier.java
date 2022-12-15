import java.util.ArrayList;

public abstract class Fuzzifier {

    public static float calculateGraphRule (float AX, float AY, float BX, float BY, float x){
        float m = (BY - AY) / (BX - AX);
        float c = AY - (m * AX);
        float y = (m * x) + c;
        return y;
    }

    //calculate the memberships of input varibles to each of their corresponding fuzzy sets according to the measured crisp value
    public static ArrayList<Variable> calculateMembership(ArrayList<Variable> fuzzifiables){
        for (Variable f : fuzzifiables){
            if (f.getType() == true){                           //ensuring it's an input variable
                if (f.getCrispValue() == f.getUpperBound()){    //if upper border value, membership to the last set = 1
                    f.getFuzzySets().get(f.getFuzzySets().size()-1).setMembership(1);
                }
                else{
                    for (int i = 0; i < f.getFuzzySets().size(); i++){
                        for (int j = 0; j < f.getFuzzySets().get(i).getArraySize()-1; j++){

                            //applying a check to determine the crisp value falls in the range of a given fuzzy set
                            if( (f.getCrispValue() >= f.getFuzzySets().get(i).getValues()[j]) && (f.getCrispValue() < f.getFuzzySets().get(i).getValues()[j+1]) ){
                                // getting the x co-ordinate values of the 2 points that form the line where the crisp value falls
                                float pointAX = f.getFuzzySets().get(i).getValues()[j];
                                float pointBX = f.getFuzzySets().get(i).getValues()[j+1];
                                float pointAY = 0;
                                float pointBY = 0;
                                // getting the y co-ordinate values
                                // the y co-ordinates in a TRI set are [0, 1, 0] and in a TRAP set they are [0, 1, 1, 0]
                                // so the first and last values are always = 0 and the 1 or 2 in the middle are = 1
                                if (j!= 0){ //checking if the first point in range is in the middle and thus give it a values of 1
                                    pointAY = 1;
                                }
                                if ((j+1) != f.getFuzzySets().get(i).getArraySize()-1){ //checking if the other point in range is in the middle and thus give it a values of 1
                                    pointBY = 1;
                                }
                                float temp = calculateGraphRule(pointAX, pointAY, pointBX, pointBY, f.getCrispValue());
                                f.getFuzzySets().get(i).setMembership(temp);
                            }
                        }
                    }
                }
            }
        }
        return fuzzifiables;
    }

    //after defuzzification, this picks the singular fuzzy set to which an output variable can belong to
    public static ArrayList<Variable> specifySet(ArrayList<Variable> fuzzifiables){
        for (Variable o : fuzzifiables){
            if (o.getType() == false){      //ensuring it's an output variable
                int maxIndex = -1;
                float maxMembership = 0;

                //basic loop to find the fuzzy set with the highest membership value
                for (int i = 0; i < o.getFuzzySets().size(); i++){
                    if(o.getFuzzySets().get(i).getMembership() >= maxMembership){
                        maxIndex = i;
                        maxMembership = o.getFuzzySets().get(i).getMembership();
                    }
                }
                o.setBelongsTo(o.getFuzzySets().get(maxIndex));
            }
        }
        return fuzzifiables;
    }
}
