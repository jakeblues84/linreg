package linreg.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import linreg.model.ColumnVariable;

public class CsvLoader {
	private static String filepath;
	
	public CsvLoader(String path) {
		this.filepath = path;
	}
	
	public static List<ColumnVariable> createColumnVariables() {
		
		String line = null;

		List<ColumnVariable> columnVariables = new ArrayList<ColumnVariable>();

		
		try {
			
			BufferedCsvReader bufferedReader = new BufferedCsvReader(new FileReader(filepath));
			
			List<String> variableNames = bufferedReader.readCsvLine();
			
			for (String name : variableNames) {
				ColumnVariable var = new ColumnVariable();
				var.setName(name);
				columnVariables.add(var);
				
				System.out.println("Variable name found: " + name);
				
			}
			
			int i = 1;
			int j = 0;
			List<String> rowValues = new ArrayList<String>();
			
			while ((rowValues = bufferedReader.readCsvLine()) != null) {
					
				if (rowValues.size() != columnVariables.size()) {
					System.out.println("Error: line " + i + " contains only " + 
							rowValues.size() + " elements. Expected " + columnVariables.size() + 
							". Terminating...");
					break;
				}
				
				j = 0;
				for (String valStr : rowValues) {
					
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
