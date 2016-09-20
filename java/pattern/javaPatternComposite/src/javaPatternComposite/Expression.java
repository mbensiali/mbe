package javaPatternComposite;

import java.util.ArrayList;
import java.util.List;

public abstract class Expression {
	
	protected List<Expression> childs;
	
	public void addChild(Expression Exp) {
		childs.add(Exp);
	}
	
	public Expression() {
		childs = new ArrayList<>();
	}
	
	public abstract double evaluer();
	
}
