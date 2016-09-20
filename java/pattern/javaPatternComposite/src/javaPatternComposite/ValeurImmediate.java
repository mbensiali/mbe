package javaPatternComposite;

public class ValeurImmediate extends Expression {
	
	private double value;
	
	

	public ValeurImmediate(double value) {
		
		this.value = value;
	}



	@Override
	public double evaluer() {
		return value;
	}


}
