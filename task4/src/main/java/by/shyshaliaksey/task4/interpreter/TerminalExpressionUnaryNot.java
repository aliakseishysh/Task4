package by.shyshaliaksey.task4.interpreter;

public class TerminalExpressionUnaryNot implements Expression {

	@Override
	public void interpret(Context context) {
		Integer result = -context.popValue();
		context.pushValue(result);
	}

	
}
