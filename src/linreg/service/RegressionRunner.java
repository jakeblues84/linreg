package linreg.service;

import java.io.FileNotFoundException;
import java.util.List;

import linreg.model.ColumnVariable;

public class RegressionRunner {
    
    public static void main(String[] args) {
        
        if (args.length != 2) {
            System.out.println("Usage: RegressionRunner <filePath> <targetVariable>");
            System.exit(1);
        }
        
        String filePath = args[0];
        String targetVariableName = args[1];
        
        CsvLoaderService csvLoader = new CsvLoaderService();
        MathService mathSvc = new MathService();
        
        List<ColumnVariable> columnVars;
        try {
            columnVars = csvLoader.createColumnVariables(filePath);
            
            for (ColumnVariable variable : columnVars) {
                if (variable.getName() == targetVariableName) {
                    System.out.println("Target variable: " + variable.getName());
                } else {
                    System.out.println("Regression variable: " + variable.getName());
                }
                
                Double avg = mathSvc.average(variable);
                System.out.println("Average : " + avg);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}