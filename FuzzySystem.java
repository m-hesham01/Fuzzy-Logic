import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FuzzySystem {
    String name;
    String desc;
    ArrayList <Variable> systemVars = new ArrayList<>();
    ArrayList <Rule> systemRules = new ArrayList<>();

    public FuzzySystem () {}
    public FuzzySystem (String name, String desc, Parser parser) throws FileNotFoundException {
        this.name = name;
        this.desc = desc;
        ArrayList<ArrayList<ArrayList<String>>> data = parser.parse();
        for(int i=0 ;i<2;i++){
            for(ArrayList<String> typedData: data.get(i)){
                if (i==0){ //variables
                    Variable variable = new Variable(typedData.get(0),typedData.get(1),Integer.parseInt(typedData.get(2)),Integer.parseInt(typedData.get(3)));
                    if (variable.getType()){
                        variable.setCrispValue(Float.parseFloat(typedData.get(typedData.size()-1)));
                    }
                    int j = 4;
                    String TRI = "TRI";
                    String TRAP = "TRAP";
                    while (j<typedData.size()-1){
                        String shapeType = typedData.get(j+1);
//                        System.out.println(typedData.get(j+1));
//                        System.out.println(typedData.get(j+i).equals(TRI));

                        if (shapeType.equals(TRI)){
                            float values[] = new float[3];
                            values[0]=Float.parseFloat(typedData.get(j+2));
                            values[1]=Float.parseFloat(typedData.get(j+3));
                            values[2]=Float.parseFloat(typedData.get(j+4));
                            FuzzySet fuzzySet = new FuzzySet(typedData.get(j),typedData.get(j+1),values);
                            variable.addFuzzySet(fuzzySet);
                            j = j+5;
                        } else if (shapeType.equals(TRAP)) {
                            float values[] = new float[4];
                            values[0]=Float.parseFloat(typedData.get(j+2));
                            values[1]=Float.parseFloat(typedData.get(j+3));
                            values[2]=Float.parseFloat(typedData.get(j+4));
                            values[3]=Float.parseFloat(typedData.get(j+5));
                            FuzzySet fuzzySet = new FuzzySet(typedData.get(j),typedData.get(j+1),values);
                            variable.addFuzzySet(fuzzySet);
                            j=j+6;
                        }
                    }
                    this.systemVars.add(variable);
                } else if (i==1) {//rules
                    Rule rule = new Rule(typedData.get(0),typedData.get(1),typedData.get(2),typedData.get(3),typedData.get(4),typedData.get(6),typedData.get(7), systemVars);
                    systemRules.add(rule);
                }
            }
        }

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

    public void fuzzifyInput(){
        systemVars = Fuzzifier.calculateMembership(systemVars);
    }

    public void infer(){
        systemRules = Inference.applyRules(systemRules);
    }

    public void defuzzify(){
        systemVars = Defuzzifier.defuzzifyOutput(systemVars);
    }

    public void determineOutputs(){
        systemVars = Fuzzifier.specifySet(systemVars);
    }

    public void produceOutput(String sPath) throws IOException{
        Path path = Path.of(sPath);
        String text = "";
        for (Variable v : systemVars){
            if (v.getType() == false){
                text = text + v.getName() + " is " + v.getBelongsTo().getName() + " and has a crisp value of " + v.getCrispValue() + "\n";
                Files.writeString(path, text);
            }
        }
    }

    public void produceGraphFile(String gpath) throws IOException{
        Path path = Path.of(gpath);
        String text = "";
        text = systemVars.size() + "\n";
        for (Variable v : systemVars){
            String message = "";
            String setsValues = "";
                for (int i = 0; i < v.getFuzzySets().size(); i++){
                    setsValues = setsValues + " " + v.getFuzzySets().get(i).getName();
                    for (int j = 0; j < v.getFuzzySets().get(i).getArraySize(); j++){
                        setsValues = setsValues + " " + v.getFuzzySets().get(i).getValues()[j];
                    }
                }
            if(v.getType() == true){
                text = text + v.getName() + " " + v.getType() + " " + v.getCrispValue() + " " + v.getFuzzySets().size() + " " + v.getFuzzySets().get(0).getType() + setsValues + "\n";
                Files.writeString(path, text);
            }
            else{
                message = "\"" + message + v.getName() + " is " + v.getBelongsTo().getName() + " and has a crisp value of " + v.getCrispValue() +"\"";
                text = text + v.getName() + " " + v.getType() + " " + v.getCrispValue() + " " + v.getFuzzySets().size() + " " + v.getFuzzySets().get(0).getType() + setsValues + " " + message +"\n";
                Files.writeString(path, text);
            }
        }
    }
}
