package javaPatternComposite;

public class Program {

	public static void main(String[] args) {
		
	
		Expression val1 = new ValeurImmediate(3);
		Expression val2 = new ValeurImmediate(4);
		Expression val3 = new ValeurImmediate(5);
		
	
		// 3+4*5
		Expression op1 = new Operation(Operation.OPERATION_MULT);
		op1.addChild(val2);
		op1.addChild(val3);
		op1.evaluer();

		Expression op2 = new Operation(Operation.OPERATION_PLUS);
		
		op2.addChild(val1);
		op2.addChild(op1);
		
		System.out.println(op2.evaluer());

	}

}
