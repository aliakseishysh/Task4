package by.shyshaliaksey.task4.parser;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;
import by.shyshaliaksey.task4.reader.TextReader;
import by.shyshaliaksey.task4.reader.impl.TextReaderImpl;

public class ParserTest {

	@Test
	public void parseTest() throws URISyntaxException, TextException {
		TextParser textParser = new TextParser();
		ParagraphParser paragraphParser = new ParagraphParser();
		SentenceParser sentenceParser = new SentenceParser();
		ElementParser elementParser = new ElementParser();
		NumberParser numberParser = new NumberParser();
		WordParser wordParser = new WordParser();
		WordWithCharactersOutsideParser wordWitchCharactersOutsideParser = new WordWithCharactersOutsideParser();
		FullElementParser fullElementParser = new FullElementParser();
		
		textParser.setNextInChain(paragraphParser);
		paragraphParser.setNextInChain(sentenceParser);
		sentenceParser.setNextInChain(elementParser);
		elementParser.setNextInChain(numberParser);
		numberParser.setNextInChain(wordParser);
		wordParser.setNextInChain(wordWitchCharactersOutsideParser);
		wordWitchCharactersOutsideParser.setNextInChain(fullElementParser);

		URI uri = getClass().getResource("/data/data.txt").toURI();
		String absolutePath = new File(uri).getAbsolutePath();
		TextReader reader = new TextReaderImpl();
		List<String> content = reader.readAllLines(absolutePath);
		String expected = content.stream().map(Object::toString).collect(Collectors.joining("\n"));
		
		AbstractComponent rootComponent = new TextComposite(ComponentType.TEXT, null);
		textParser.parse(rootComponent, expected);
		String actual = rootComponent.toString();
		Assert.assertEquals(actual, expected);
	}
	
}
