package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.Component;
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
	public void parse(Component component) throws TextException {
		ComponentName name = component.getComponentName();
		if (name == ComponentName.TEXT) {
			String content = component.getContent();
			Pattern pattern = Pattern.compile(PARAGRAPHS);
			Matcher matcher = pattern.matcher(content);
			// List<String> paragraphs = new ArrayList<>();
            while (matcher.find()) {
				String paragraph = content.substring(matcher.start(), matcher.end());
				// paragraphs.add(paragraph);
				TextComposite paragraphComposite = new TextComposite(ComponentName.PARAGRAPH, paragraph);
				component.add(paragraphComposite);
				nextChain.parse(paragraphComposite);
			}
		} else {
			nextChain.parse(component);
		}
	}
	
}
