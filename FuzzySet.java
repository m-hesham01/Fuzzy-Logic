public class FuzzySet {
    String name;
    String type;
    int N;                              //size of the Values[] array... 3 if type=TRI and 4 if type =TRAP
    int Values[];
    float membership;
    public FuzzySet() {}
    public FuzzySet(String name, String type, int V[]) {
        this.name = name;
        this.type = type;
        setN();
        Values = new int[N];
        for (int i=0; i< N; i++){
            Values[i] = V[i];
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public int[] getValues(){
        return Values;
    }

    public void setValues(int V[]){
        setN();
        Values = new int[N];
        for (int i=0; i< N; i++){
            Values[i] = V[i];
        }
    }

    public void setN(){         //TODO: add invalidity check later... maybe in parser??
        if (type == "tri"){
            N = 3;
        }
        if (type == "trap"){
            N = 4;
        }
    }

    public int getArraySize(){
        return N;
    }

    public float getMembership() {
        return membership;
    }
    public void setMembership(float membership) {
        this.membership = membership;
    }
}
