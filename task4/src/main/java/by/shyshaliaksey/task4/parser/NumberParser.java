package by.shyshaliaksey.task4.parser;

import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class NumberParser extends Chain {

	private static final String NUMBER = "^[0-9]+$";

	@Override
	public void parse(AbstractComponent parentComponent, String contentToParse) throws TextException {
		if (parentComponent.getComponentName() == ComponentName.ELEMENT) {
			if (Pattern.matches(NUMBER, contentToParse)) {
				TextComposite numberComposite = new TextComposite(ComponentName.NUMBER, parentComponent);
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
