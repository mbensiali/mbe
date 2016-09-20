package javaPatternComposite;

public class Operation extends Expression {
	
	public static final int OPERATION_PLUS = 0;
	public static final int OPERATION_MULT = 1;
	
	private int typeOperation;
	private double result;
	
	public Operation(int typeOperation) {
		
		this.typeOperation = typeOperation;
		
	}

	@Override
	public double evaluer() {
		switch (typeOperation){
			case OPERATION_PLUS:
				result = childs.get(0).evaluer() + childs.get(1).evaluer(); 
				break;
			
			case OPERATION_MULT:
				result = childs.get(0).evaluer() * childs.get(1).evaluer();
				break;
			default:
		}

		return result;
	}

}
