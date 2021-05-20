package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class WordWithCharactersOutsideParser extends AbstractTextChain {

	private static final String WORD_WITH_CHARACTERS_OUTSIDE = "^([-(),:'\\\"]+)?([A-Za-z]+)([-(),:'\\\".…?!]+)?$";

	@Override
	public void parse(AbstractComponent parentComponent, String contentToParse) throws TextException {
		if (parentComponent.getComponentName() == ComponentType.ELEMENT) {
			Pattern pattern = Pattern.compile(WORD_WITH_CHARACTERS_OUTSIDE);
			Matcher matcher = pattern.matcher(contentToParse);
			if (matcher.find()) {
				this.parseSymbols(parentComponent, matcher.group(1));
				TextComposite wordComposite = new TextComposite(ComponentType.WORD, parentComponent);
				this.parseSymbols(wordComposite, matcher.group(2));
				parentComponent.add(wordComposite);
				parseSymbols(parentComponent, matcher.group(3));
			} else {
				this.nextInChain.parse(parentComponent, contentToParse);
			}
		} else {
			this.nextInChain.parse(parentComponent, contentToParse);
		}
	}

}
