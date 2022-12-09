public class FuzzySet {
    String name;
    String type;
    int N;                              //size of the Values[] array... 3 if type=TRI and 4 if type =TRAP
    float Values[];
    float membership = 0;
    float centroid;

    public FuzzySet() {}
    public FuzzySet(String name, String type, float V[]) {
        this.name = name;
        this.type = type;
        setN();
        Values = new float[N];
        for (int i=0; i< N; i++){
            Values[i] = V[i];
        }
        calculateCentroid();
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

    public float[] getValues(){
        return Values;
    }

    public void setValues(int V[]){
        setN();
        Values = new float[N];
        for (int i=0; i< N; i++){
            Values[i] = V[i];
        }
    }

    public void setN(){
        if (type.equals("TRI")){
            N = 3;
        }
        if (type.equals("TRAP")){
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

    public float getCentroid() {
        return centroid;
    }
    public void calculateCentroid() {
        float sum = 0;
        for (int i = 0; i < N; i++){
            sum += Values[i];
        }
        centroid = sum / N;
    }
}
