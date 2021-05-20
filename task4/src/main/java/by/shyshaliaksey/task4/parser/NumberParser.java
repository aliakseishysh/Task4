package by.shyshaliaksey.task4.parser;

import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class NumberParser extends AbstractTextChain {

	private static final String NUMBER = "^[0-9]+$";

	@Override
	public void parse(AbstractComponent parentComponent, String contentToParse) throws TextException {
		if (parentComponent.getComponentName() == ComponentType.ELEMENT) {
			if (Pattern.matches(NUMBER, contentToParse)) {
				TextComposite numberComposite = new TextComposite(ComponentType.NUMBER, parentComponent);
				this.parseSymbols(numberComposite, contentToParse);
				parentComponent.add(numberComposite);
			} else {
				this.nextInChain.parse(parentComponent, contentToParse);
			}
		} else {
			this.nextInChain.parse(parentComponent, contentToParse);
		}
	}
	
}
