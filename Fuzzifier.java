import java.util.ArrayList;

public class Fuzzifier {
    ArrayList <Variable> fuzzifiables = new ArrayList<>();

    public Fuzzifier(ArrayList<Variable> fuzz) {
        fuzzifiables = fuzz;
    }

    public void calculateMembership(){
        for (Variable f : fuzzifiables){
            if (f.getType() == true){                                    //ensuring it's an input variable
             for (int i = 0; i < f.getFuzzySets().size(); i++){
                for (int j = 0; j < f.getFuzzySets().get(i).getArraySize()-1; j++){
                    if( (f.getCrispValue() >= f.getFuzzySets().get(i).getValues()[j]) && (f.getCrispValue() < f.getFuzzySets().get(i).getValues()[j+1]) ){
                        int pointAX = f.getFuzzySets().get(i).getValues()[j];
                        int pointBX = f.getFuzzySets().get(i).getValues()[j+1];
                    }
                }
             }
            }   
        }
    }
}
