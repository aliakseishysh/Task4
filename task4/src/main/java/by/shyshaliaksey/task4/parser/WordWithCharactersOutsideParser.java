package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.Component;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class WordWithCharactersOutsideParser implements Chain {

	private static final String WORD_WITH_CHARACTERS_OUTSIDE = "^([-(),:'\\\"]+)([A-Za-z]+)([-(),:'\\\".?!]+)$";
	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}
	
	// TODO IMPLEMENT
	@Override
	public void parse(Component parentComponent, String contentToParse) throws TextException {
		if (parentComponent.getComponentName() == ComponentName.SENTENCE) {
			Pattern pattern = Pattern.compile(WORD_WITH_CHARACTERS_OUTSIDE);
			Matcher matcher = pattern.matcher(contentToParse);
			while (matcher.find()) {
				String element = contentToParse.substring(matcher.start(), matcher.end());
				TextComposite elementComposite = new TextComposite(ComponentName.ELEMENT);
				parentComponent.add(elementComposite);
				nextChain.parse(elementComposite, element);
			}
		} else {
			nextChain.parse(parentComponent, contentToParse);
		}
	}

}
