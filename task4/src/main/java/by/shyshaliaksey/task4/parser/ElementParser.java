package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.Component;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class ElementParser implements Chain {

	private static final String ELEMENT = "([\\t\\w()<>|&^.\\,'~-]+)( +|\\n|$)";
	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}
	
	@Override
	public void parse(Component component) throws TextException {
		if (component.getComponentName() == ComponentName.ELEMENT) {
			String content = component.getContent();
			Pattern pattern = Pattern.compile(ELEMENT);
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				String element = content.substring(matcher.start(), matcher.end());
				// paragraphs.add(paragraph);
				TextComposite elementComposite = new TextComposite(ComponentName.ELEMENT, element);
				component.add(elementComposite);
				nextChain.parse(elementComposite);
			}
		} else {
			nextChain.parse(component);
		}
	}
	
}
