package by.shyshaliaksey.task4.interpreter;

import by.shyshaliaksey.task4.interpreter.impl.Context;

@FunctionalInterface
public interface Expression {

	public void interpret(Context context);
	
}
