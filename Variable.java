import java.util.ArrayList;

public class Variable {
    //input parameters
    String name;
    boolean type;       // input variables = true... output variables = false
    int lowerBound;
    int upperBound;
    ArrayList <FuzzySet> fuzzySets = new ArrayList<>();
    float crispValue;

    //for outputs variables only: specifies the "winner" fuzzy set with the highest membership value
    FuzzySet belongsTo;

    public Variable() {}
    public Variable (String name, String type, int lowerBound, int upperBound) {
        this.name = name;
        if (type.equals("IN")){
            this.type=true;
        } else if (type.equals("OUT")) {
            this.type=false;
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
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

    public ArrayList<FuzzySet> getFuzzySets() {
        return fuzzySets;
    }

    public void setFuzzySets (ArrayList<FuzzySet> F){
        fuzzySets = F;
    }
    public void addFuzzySet(FuzzySet fazfooz){
        this.fuzzySets.add(fazfooz);
    }
    public float getCrispValue() {
        return crispValue;
    }

    public void setCrispValue(float crispValue) {
        this.crispValue = crispValue;
    }

    public FuzzySet getBelongsTo() {
        return belongsTo;
    }
    public void setBelongsTo(FuzzySet belongsTo) {
        this.belongsTo = belongsTo;
    }

}
