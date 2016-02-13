package linreg.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import linreg.model.ColumnVariable;

public class CsvLoaderService {
	public static List<ColumnVariable> createColumnVariables(String filePath) throws FileNotFoundException {
		
		String line = null;

		List<ColumnVariable> columnVariables = new ArrayList<ColumnVariable>();
		
		try {
			FileReader fileReader = new FileReader(filePath);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			List<String> variableNames = new ArrayList<String>();
			line = bufferedReader.readLine();
			
			variableNames = Arrays.asList(line.split(","));
			
			for (String name : variableNames) {
				ColumnVariable var = new ColumnVariable();
				var.setName(name);
				columnVariables.add(var);
				
				System.out.println("Variable name found: " + name);
				
			}
			
			int i = 1;
			int j = 0;
			
			while ((line = bufferedReader.readLine()) != null) {
				List<String> rowValueStrings = new ArrayList<String>();
				
				System.out.println(line);
				rowValueStrings = Arrays.asList(line.split(","));
				
				if (rowValueStrings.size() != columnVariables.size()) {
					System.out.println("Error: line " + i + " contains only " + 
							rowValueStrings.size() + " elements. Expected " + columnVariables.size() + 
							". Terminating...");
					break;
				}
				
				j = 0;
				for (String valStr : rowValueStrings) {
					
					Double val = Double.parseDouble(valStr);
					columnVariables.get(j).add(val);
					
					
					j++;
				}
				
				i++;

			}
			
			System.out.println("Stored " + (i - 1) + " rows");
			
			bufferedReader.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return columnVariables;
	};
}
