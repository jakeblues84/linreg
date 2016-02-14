package linreg.model;

public class PerformanceMetric {
	private double rSquared;
	private double min;
	private double q1;
	private double med;
	private double q3;
	private double max;
	
	public double getrSquared() {
		return rSquared;
	}
	public void setrSquared(double rSquared) {
		this.rSquared = rSquared;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getQ1() {
		return q1;
	}
	public void setQ1(double q1) {
		this.q1 = q1;
	}
	public double getMed() {
		return med;
	}
	public void setMed(double med) {
		this.med = med;
	}
	public double getQ3() {
		return q3;
	}
	public void setQ3(double q3) {
		this.q3 = q3;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
}
