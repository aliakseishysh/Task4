package by.shyshaliaksey.task4.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.Component;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class ParagraphParser implements Chain {

	private static final String SENTENCE = "\\s+[A-Za-z\\s-(),0-9<>~&|^']+\\.\\n?";
	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void parse(Component component) throws TextException {
		ComponentName name = component.getComponentName();
		if (name == ComponentName.PARAGRAPH) {
			String content = component.getContent();
			Pattern pattern = Pattern.compile(SENTENCE);
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				String sentence = content.substring(matcher.start(), matcher.end());
				// paragraphs.add(paragraph);
				TextComposite sentenceComposite = new TextComposite(ComponentName.SENTENCE, sentence);
				component.add(sentenceComposite);
				nextChain.parse(sentenceComposite);
			}
		} else {
			nextChain.parse(component);
		}
	}
	
}
