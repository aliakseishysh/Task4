package by.shyshaliaksey.task4.interpreter;

public class NonterminalExpression implements Expression {

	private int number;
	
	public NonterminalExpression(int number) {
		this.number = number;
	}

	@Override
	public void interpret(Context context) {
		context.pushValue(number);
	}
	


}
