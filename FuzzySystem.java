import java.util.ArrayList;

public class FuzzySystem {
    String name;
    String desc;
    ArrayList <Variable> SystemVars = new ArrayList<>();

    public FuzzySystem () {}

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
}
