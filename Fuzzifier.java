import java.util.ArrayList;

public class Fuzzifier {
    ArrayList <Variable> fuzzifiables = new ArrayList<>();

    public Fuzzifier(ArrayList<Variable> fuzz) {
        fuzzifiables = fuzz;
    }

    public float calculateGraphRule (int AX, float AY, int BX, float BY, int x){
        float m = (BY - AY) / (BX - AX);
        float c = AY - (m * AX);
        float y = (m * x) + c;
        return y;
    }

    public ArrayList <Variable> calculateMembership(){
        for (Variable f : fuzzifiables){
            if (f.getType() == true){                                    //ensuring it's an input variable
                for (int i = 0; i < f.getFuzzySets().size(); i++){
                    for (int j = 0; j < f.getFuzzySets().get(i).getArraySize()-1; j++){
                        if( (f.getCrispValue() >= f.getFuzzySets().get(i).getValues()[j]) && (f.getCrispValue() < f.getFuzzySets().get(i).getValues()[j+1]) ){
                            int pointAX = f.getFuzzySets().get(i).getValues()[j];
                            int pointBX = f.getFuzzySets().get(i).getValues()[j+1];
                            float pointAY = 0;
                            float pointBY = 0;
                            if (j!= 0){
                                pointAY = 1;
                            }
                            if ((j+1) != f.getFuzzySets().get(i).getArraySize()-1){
                                pointBY = 1;
                            }
                            float temp = calculateGraphRule(pointAX, pointAY, pointBX, pointBY, f.getCrispValue());
                            System.out.println("Membership of variable " + f.getName() + " to the set " + f.getFuzzySets().get(i).getName() + " is " + temp);
                            f.getFuzzySets().get(i).setMembership(temp);
                        }
                    }
                }
            }
        }
        return fuzzifiables;
    }
}
