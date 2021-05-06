package by.shyshaliaksey.task4.interpreter;

public class TerminalExpressionXor implements Expression {

	@Override
	public void interpret(Context context) {
		context.pushValue(context.popValue() ^ context.popValue());
	}

	
}
