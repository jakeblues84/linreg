package linreg.model;

import java.util.ArrayList;
import java.util.List;

public class ColumnVariable {

	private String name;
	
	private PerformanceMetric performanceMetric;
	
	private List<Double> values = new ArrayList<Double>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PerformanceMetric getPerformanceMetric() {
		return performanceMetric;
	}

	public void setPerformanceMetric(PerformanceMetric performanceMetric) {
		this.performanceMetric = performanceMetric;
	}

	public List<Double> getValues() {
		return values;
	}

	public void setValues(List<Double> newValues) {
		values = newValues;
	}
	
	public void add(Double val) {
		values.add(val);
	}
}
