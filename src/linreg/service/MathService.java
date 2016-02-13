package linreg.service;

import linreg.model.ColumnVariable;

public class MathService {
    public static Double average (ColumnVariable columnVariable) {
        return sum(columnVariable) / columnVariable.getValues().size();
    }
    
    public static Double sum (ColumnVariable columnVariable) {
        
        Double summedValues = 0.0;
        
        for (Double value : columnVariable.getValues()) {
            summedValues += value;
        }
        
        return summedValues;
    }
    
    
}