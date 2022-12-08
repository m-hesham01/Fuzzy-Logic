import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    String path;
    public Parser (String path){
        this.path=path;
    }
    public ArrayList<ArrayList<ArrayList<String>>> parse() throws FileNotFoundException {
        ArrayList<ArrayList<ArrayList<String>>> parsedData = new ArrayList();
        ArrayList<ArrayList<String>> variables = new ArrayList();
        ArrayList<ArrayList<String>> rules = new ArrayList();
        File file = new File(this.path);
        Scanner scanner = new Scanner(file);
        String option = new String();
        while (scanner.hasNextLine()){
            option = scanner.nextLine();
            if (option.equals("VARS")){
                int noOfvars = scanner.nextInt();
                for (int i=0;i<noOfvars;i++){
                    ArrayList<String> variable = new ArrayList();
                    for (int j=0; j<4;j++){
                        variable.add(scanner.next());
                    }
                    int numberOfSets = scanner.nextInt();
                    for (int j=0;j<numberOfSets;j++){
                        variable.add(scanner.next());
                        String setShape=scanner.next();
                        variable.add(setShape);
                        if (setShape.equals("TRI")){
                            for (int k=0;k<3;k++){
                                variable.add(scanner.next());
                            }
                        } else if (setShape.equals("TRAP")) {
                            for (int k=0;k<4;k++){
                                variable.add(scanner.next());
                            }
                        }
                        else{
                            System.out.println("File is not matching correct format 1");
                            break;
                        }
                    }
                    if (variable.get(1).equals("IN")){
                        if (scanner.next().equals("CRISP")){
                            variable.add(scanner.next());
                        }
                        else{
                            System.out.println("File is not matching correct format 2");
                            break;
                        }
                    }
                    variables.add(variable);
                }
            } else if (option.equals("RULES")) {
                int numberOfRules=scanner.nextInt();
                for(int i=0;i<numberOfRules;i++){
                    ArrayList<String> rule =new ArrayList();
                    for(int j=0;j<8;j++){
                        rule.add(scanner.next());
                    }
                    rules.add(rule);
                }
            }
            else {
                System.out.println("File is not matching correct format 3");
                System.out.println(option);
            }
        }
        scanner.close();
        parsedData.add(variables);
        parsedData.add(rules);
        return parsedData;
    }
}
