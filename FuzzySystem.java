import java.util.ArrayList;

public class FuzzySystem {
    String name;
    String desc;
    ArrayList <Variable> systemVars = new ArrayList<>();
    ArrayList <Rule> systemRules = new ArrayList<>();
    ArrayList <Variable> outputVars = new ArrayList<>();

    public FuzzySystem () {}
    public FuzzySystem (String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public ArrayList<Variable> getSystemVariables(){
        return systemVars;
    }

    public void setSystemVariables(ArrayList<Variable> V){
        systemVars = V;
    }

    public ArrayList<Rule> getSystemRules (){
        return systemRules;
    }

    public void setSystemRules (ArrayList<Rule> R) {
        systemRules = R;
    }

    public void startFuzzification(){
        Fuzzifier fazfoz = new Fuzzifier(systemVars);
        systemVars = fazfoz.calculateMembership();
    }

}
