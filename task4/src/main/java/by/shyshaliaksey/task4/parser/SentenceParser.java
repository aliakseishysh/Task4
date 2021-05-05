package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.Component;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class SentenceParser implements Chain {

	private static final String ELEMENT = "([\\t\\w()<>|&^.\\,'~-]+)( +|\\n|\\Z)";
	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void parse(Component component, String content) throws TextException {
		if (component.getComponentName() == ComponentName.SENTENCE) {
			Pattern pattern = Pattern.compile(ELEMENT);
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				String element = content.substring(matcher.start(), matcher.end());
				// paragraphs.add(paragraph);
				TextComposite elementComposite = new TextComposite(ComponentName.ELEMENT);
				component.add(elementComposite);
				nextChain.parse(elementComposite, element);
			}
		} else {
			nextChain.parse(component, content);
		}
	}

}
