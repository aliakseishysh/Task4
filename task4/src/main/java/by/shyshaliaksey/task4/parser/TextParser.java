package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class TextParser extends AbstractTextChain {

	private static final String PARAGRAPHS = "\\t+[^\\t]*";

	@Override
	public void parse(AbstractComponent abstractComponent, String content) throws TextException {
		ComponentType name = abstractComponent.getComponentName();
		if (name == ComponentType.TEXT) {
			Pattern pattern = Pattern.compile(PARAGRAPHS);
			Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
				String paragraph = content.substring(matcher.start(), matcher.end());
				TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH, abstractComponent);
				this.nextInChain.parse(paragraphComposite, paragraph);
				abstractComponent.add(paragraphComposite);
			}
		} else {
			this.nextInChain.parse(abstractComponent, content);
		}
	}
	
}
