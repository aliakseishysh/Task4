package by.shyshaliaksey.task4.parser;

import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class WordParser extends AbstractTextChain {

	private static final String WORD = "^[A-Za-z]+$";

	@Override
	public void parse(AbstractComponent parentComponent, String contentToParse) throws TextException {
		if (parentComponent.getComponentName() == ComponentName.ELEMENT) {
			if (Pattern.matches(WORD, contentToParse)) {
				TextComposite wordComposite = new TextComposite(ComponentName.WORD, parentComponent);
				this.parseSymbols(wordComposite, contentToParse);
				parentComponent.add(wordComposite);
			} else {
				this.nextInChain.parse(parentComponent, contentToParse);
			}
		} else {
			this.nextInChain.parse(parentComponent, contentToParse);
		}
	}
	
}
