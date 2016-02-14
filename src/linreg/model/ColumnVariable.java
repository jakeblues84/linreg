package linreg.model;

import java.util.ArrayList;
import java.util.Collections;
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

	public List<Double> getRows() {
		return values;
	}

	public void setRows(List<Double> newValues) {
		values = newValues;
	}
	
	public void add(Double val) {
		values.add(val);
	}
	
	private Double median(List<Double> values) {
		Collections.sort(values);
		Double med;
		if (values.size() % 2 == 0) {
			med = (values.get(breakpoint(values) - 1) + values.get(breakpoint(values))) / 2;
		} else {
			med = values.get(breakpoint(values));
		}
		
		return med;
	}
	
	private int breakpoint(List<Double> values) {
		int bp;
		
		if (values.size() % 2 == 0) {
			bp = (values.size()) / 2;
		} else {
			bp = (values.size() - 1) / 2;
		}
		
		return bp;
	}
	
	public void runRegression(){
		PerformanceMetric performance = new PerformanceMetric();
		
		Collections.sort(values);
		
		System.out.print("Values for " + name + ": ");
		
		for (Double val : values ) {
			System.out.print(val + ", ");
		}
		
		System.out.print(" (" + values.size() + " items)\n");
		
		int bp = breakpoint(values);
		
		List<Double> lower = values.subList(0, bp);
		List<Double> upper;
		
		if (values.size() % 2 == 0) {
			upper = values.subList(bp, values.size());
		} else {
			upper = values.subList(bp + 1, values.size());
		}
		
		performance.setMin(values.get(0));
		System.out.println(getName() + " min is " + performance.getMin());

		performance.setQ1(median(lower));
		System.out.println(getName() + " q1 is " + performance.getQ1());
		
		performance.setMed(median(values));
		System.out.println(getName() + " med is " + performance.getMed());

		performance.setQ3(median(upper));
		System.out.println(getName() + " q3 is " + performance.getQ3());
		
		performance.setMax(values.get(values.size() - 1));
		System.out.println(getName() + " max is " + performance.getMax());
		
		System.out.println(performance.boxAndWhiskers());
		
		
	}
}