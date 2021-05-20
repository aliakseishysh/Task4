package by.shyshaliaksey.task4.parser;

import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;
import by.shyshaliaksey.task4.interpreter.BinaryInterpreter;
import by.shyshaliaksey.task4.interpreter.impl.BinaryInterpreterImpl;
import by.shyshaliaksey.task4.notation.NotationChanger;
import by.shyshaliaksey.task4.notation.impl.NotationChangerImpl;

public class ExpressionParser extends AbstractTextChain {

	private static final String EXPRESSION = "^([~0-9|&()<>^]+)$";

	@Override
	public void parse(AbstractComponent parentComponent, String contentToParse) throws TextException {
		ComponentType componentType = parentComponent.getComponentName();
		if (componentType == ComponentType.ELEMENT) {
			if (Pattern.matches(EXPRESSION, contentToParse)) {
				NotationChanger notationChangerImpl = new NotationChangerImpl();
				String postfixNotation = notationChangerImpl.normalToPrefix(contentToParse);
				BinaryInterpreter interpreter = new BinaryInterpreterImpl(postfixNotation);
				Number result = interpreter.calculate();
				String resultString = result.toString();
				TextComposite numberComposite = new TextComposite(ComponentType.NUMBER, parentComponent);
				this.parseSymbols(numberComposite, resultString);
				parentComponent.add(numberComposite);
			} else {
				this.nextInChain.parse(parentComponent, contentToParse);
			}
		} else {
			this.nextInChain.parse(parentComponent, contentToParse);
		}
	}
	
}
