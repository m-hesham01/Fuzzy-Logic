import java.util.ArrayList;

public abstract class Fuzzifier {
    public static float calculateGraphRule (float AX, float AY, float BX, float BY, float x){
        float m = (BY - AY) / (BX - AX);
        float c = AY - (m * AX);
        float y = (m * x) + c;
        return y;
    }

    public static ArrayList<Variable> calculateMembership(ArrayList<Variable> fuzzifiables){
        for (Variable f : fuzzifiables){
            if (f.getType() == true){                           //ensuring it's an input variable
                if (f.getCrispValue() == f.getUpperBound()){    //if upper border value, membership to the last set = 1
                    f.getFuzzySets().get(f.getFuzzySets().size()-1).setMembership(1);
                }
                else{
                    for (int i = 0; i < f.getFuzzySets().size(); i++){
                        for (int j = 0; j < f.getFuzzySets().get(i).getArraySize()-1; j++){
                            if( (f.getCrispValue() >= f.getFuzzySets().get(i).getValues()[j]) && (f.getCrispValue() < f.getFuzzySets().get(i).getValues()[j+1]) ){
                                float pointAX = f.getFuzzySets().get(i).getValues()[j];
                                float pointBX = f.getFuzzySets().get(i).getValues()[j+1];
                                float pointAY = 0;
                                float pointBY = 0;
                                if (j!= 0){
                                    pointAY = 1;
                                }
                                if ((j+1) != f.getFuzzySets().get(i).getArraySize()-1){
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
}
