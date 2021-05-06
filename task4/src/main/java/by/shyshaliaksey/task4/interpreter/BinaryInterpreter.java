package by.shyshaliaksey.task4.interpreter;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryInterpreter {

	private ArrayList<Expression> listExpression;
	
	public BinaryInterpreter(String expression) {
		listExpression = new ArrayList<>();
		parse(expression);
	}
	
	public Number calculate() {
		Context context = new Context();
		for (Expression expression: listExpression) {
			expression.interpret(context);
		}
		return context.popValue();
	}
	
	private void parse(String expression) {
		for (String lexeme: expression.split("\\p{Blank}+")) {
			if (lexeme.isEmpty()) {
				continue;
			}
			char temp = lexeme.charAt(0);
			switch (temp) {
			case 'L':
				listExpression.add(new TerminalExpressionLeftShift());
				break;
			default:
				Scanner scan = new Scanner(lexeme);
				if (scan.hasNextInt()) {
					listExpression.add(new NonterminalExpression(scan.nextInt()));
				}
			}
		}
	}
}
	 