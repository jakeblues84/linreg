package linreg.service;

import java.util.List;

import linreg.model.ColumnVariable;

public class RegressionRunner {
	
	private static String filePath = "resources/data.csv";
	
	public static void main(String[] args) {
		

		System.out.println("Initializing CSV Load for " + filePath);
		
		CsvLoader csv = new CsvLoader(filePath);
		List<ColumnVariable> variables = csv.createColumnVariables();
		
		for (ColumnVariable var : variables) {
			var.runRegression();
		}
		
	}
}
