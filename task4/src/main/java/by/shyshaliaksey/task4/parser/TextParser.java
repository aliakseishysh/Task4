package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class TextParser implements Chain {

	private static final String PARAGRAPHS = "\\t[^\\t]*";
	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void parse(AbstractComponent abstractComponent, String content) throws TextException {
		ComponentName name = abstractComponent.getComponentName();
		if (name == ComponentName.TEXT) {
			Pattern pattern = Pattern.compile(PARAGRAPHS);
			Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
				String paragraph = content.substring(matcher.start(), matcher.end());
				TextComposite paragraphComposite = new TextComposite(ComponentName.PARAGRAPH, abstractComponent);
				nextChain.parse(paragraphComposite, paragraph);
				abstractComponent.add(paragraphComposite);
			}
		} else {
			nextChain.parse(abstractComponent, content);
		}
	}
	
}
