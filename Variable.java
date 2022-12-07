import java.util.ArrayList;

public class Variable {
    String name;
    boolean type;
    int lowerBound;
    int upperBound;
    int NumOfSets;
    ArrayList <FuzzySet> fuzzySets = new ArrayList<>();
    int crispValue;

    public Variable() {}
    public Variable (String name, boolean type, int lowerBound, int upperBound, int NumOfSets) {
        this.name = name;
        this.type = type;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.NumOfSets = NumOfSets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type){
        this.type = type;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public int getNumOfSets() {
        return NumOfSets;
    }
    public void setNumOfSets(int numOfSets) {
        NumOfSets = numOfSets;
    }

    public ArrayList<FuzzySet> getFuzzySets() {
        return fuzzySets;
    }

    public void setFuzzySets (ArrayList<FuzzySet> F){
        fuzzySets = F;
    }

    public void setMembership(float[] M){
        for (int i = 0; i < NumOfSets; i++){
            memberships[i] = M[i];
        }
    }

    public float[] getMembership(){
        return memberships;
    }

    public int getCrispValue() {
        return crispValue;
    }

    public void setCrispValue(int crispValue) {
        this.crispValue = crispValue;
    }

}
