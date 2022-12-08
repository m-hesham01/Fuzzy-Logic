import java.util.ArrayList;

public abstract class Defuzzifier {
    public static void calcCentroids(FuzzySystem s) { 

        for(int i = 0; i < s.outputVars.size(); i++){ // get outVar sets 
            ArrayList<FuzzySet> tempSets = s.outputVars.get(i).getFuzzySets();
            float [] centroids = new float[tempSets.size()];
            for(int j = 0; j < tempSets.size(); j++){ // calc centroids for outVar sets
                FuzzySet tempSet = tempSets.get(j);
                float[] tempValue = tempSet.getValues();
                int sum =0;
                for(int k = 0; k < tempValue.length; k++){
                    sum += tempValue[k];
                }
                centroids[i] = sum/tempValue.length;
                System.out.println(centroids[i]);
            }
            
        }
    }

}
