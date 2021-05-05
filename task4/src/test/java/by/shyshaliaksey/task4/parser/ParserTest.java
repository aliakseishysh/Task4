package by.shyshaliaksey.task4.parser;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import by.shyshaliaksey.task4.entity.Component;
import by.shyshaliaksey.task4.entity.ComponentName;
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
		WordParser wordParser = new WordParser();
		WordWithCharactersOutsideParser wordWitchCharactersOutsideParser = new WordWithCharactersOutsideParser();
		ExpressionParser expressionParser = new ExpressionParser();
		
		
		textParser.setNextChain(paragraphParser);
		paragraphParser.setNextChain(sentenceParser);
		sentenceParser.setNextChain(elementParser);
		elementParser.setNextChain(wordParser);
		wordParser.setNextChain(wordWitchCharactersOutsideParser);
		wordWitchCharactersOutsideParser.setNextChain(expressionParser);
		
		URI uri = getClass().getResource("/data/data.txt").toURI();
		String absolutePath = new File(uri).getAbsolutePath();
		TextReader reader = new TextReaderImpl();
		List<String> content = reader.readAllLines(absolutePath);
		String stringContent = content.stream().map(Object::toString).collect(Collectors.joining(""));
		
		Component rootComponent = new TextComposite(ComponentName.TEXT);
		textParser.parse(rootComponent, stringContent);
		System.out.println(rootComponent);
	}
	
}
