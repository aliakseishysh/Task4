package by.shyshaliaksey.task4.service;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;
import by.shyshaliaksey.task4.parser.ElementParser;
import by.shyshaliaksey.task4.parser.ExpressionParser;
import by.shyshaliaksey.task4.parser.FullElementParser;
import by.shyshaliaksey.task4.parser.NumberParser;
import by.shyshaliaksey.task4.parser.ParagraphParser;
import by.shyshaliaksey.task4.parser.SentenceParser;
import by.shyshaliaksey.task4.parser.TextParser;
import by.shyshaliaksey.task4.parser.WordParser;
import by.shyshaliaksey.task4.parser.WordWithCharactersOutsideParser;
import by.shyshaliaksey.task4.reader.TextReader;
import by.shyshaliaksey.task4.reader.impl.TextReaderImpl;
import by.shyshaliaksey.task4.service.impl.TextCalculationServiceImpl;

public class TextCalculationServiceTest {

	private AbstractComponent rootComponent;
	
	@BeforeClass
	public void parseData() throws URISyntaxException, TextException {
		TextParser textParser = new TextParser();
		ParagraphParser paragraphParser = new ParagraphParser();
		SentenceParser sentenceParser = new SentenceParser();
		ElementParser elementParser = new ElementParser();
		NumberParser numberParser = new NumberParser();
		WordParser wordParser = new WordParser();
		WordWithCharactersOutsideParser wordWitchCharactersOutsideParser = new WordWithCharactersOutsideParser();
		ExpressionParser expressionParser = new ExpressionParser();
		FullElementParser fullElementParser = new FullElementParser();
		
		textParser.setNextInChain(paragraphParser);
		paragraphParser.setNextInChain(sentenceParser);
		sentenceParser.setNextInChain(elementParser);
		elementParser.setNextInChain(numberParser);
		numberParser.setNextInChain(wordParser);
		wordParser.setNextInChain(wordWitchCharactersOutsideParser);
		wordWitchCharactersOutsideParser.setNextInChain(expressionParser);
		expressionParser.setNextInChain(fullElementParser);
		
		URI uri = getClass().getResource("/data/data.txt").toURI();
		String absolutePath = new File(uri).getAbsolutePath();
		TextReader reader = new TextReaderImpl();
		List<String> content = reader.readAllLines(absolutePath);
		String stringContent = content.stream().map(Object::toString).collect(Collectors.joining("\n"));
		
		rootComponent = new TextComposite(ComponentType.TEXT, null);
		textParser.parse(rootComponent, stringContent);
	}
	
	@Test
	public void calculateSentenceCount() throws TextException {
		TextComposite paragraph0 = (TextComposite) rootComponent.getChild(0);
		TextComposite paragraph1 = (TextComposite) rootComponent.getChild(1);
		TextComposite paragraph2 = (TextComposite) rootComponent.getChild(2);
		TextComposite paragraph3 = (TextComposite) rootComponent.getChild(3);
		TextCalculationService calculationService = new TextCalculationServiceImpl();
		boolean actual = calculationService.calculateSentencesInParagraph(paragraph0) == 2
				&& calculationService.calculateSentencesInParagraph(paragraph1) == 2
				&& calculationService.calculateSentencesInParagraph(paragraph2) == 1
				&& calculationService.calculateSentencesInParagraph(paragraph3) == 1;
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void calculateAllIdenticalWords() {
		TextCalculationService calculationService = new TextCalculationServiceImpl();
		int actual = calculationService.calculateAllIdenticalWords((TextComposite) rootComponent, "It");
		int expected = 6;
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void calculateVowels() throws TextException {
		TextCalculationService calculationService = new TextCalculationServiceImpl();
		int actual = calculationService.calculateVowelCount(rootComponent);
		int expected = 227;
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void calculateConsonants() throws TextException {
		TextCalculationService calculationService = new TextCalculationServiceImpl();
		int actual = calculationService.calculateConsonantCount(rootComponent);
		int expected = 351;
		Assert.assertEquals(actual, expected);
	}
	
}
