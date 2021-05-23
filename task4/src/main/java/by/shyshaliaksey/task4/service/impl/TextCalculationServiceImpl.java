package by.shyshaliaksey.task4.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.exception.TextException;
import by.shyshaliaksey.task4.service.TextCalculationService;
import by.shyshaliaksey.task4.service.TextSearchService;

public class TextCalculationServiceImpl implements TextCalculationService {
	
	private static final String VOWEL = "[aeiouAEIOU]";
	private static final String CONSONANT = "[a-zA-Z&&[^aeiouAEIOU]]";

	@Override
	public int calculateSentencesInParagraph(AbstractComponent paragraph) throws TextException {
		ComponentType componentType = paragraph.getComponentName();
		if (componentType == ComponentType.PARAGRAPH) {
			int sentenceCount = paragraph.getComponentsSize();
			return sentenceCount;
		} else {
			throw new TextException("Composite type != PARAGRAPH: " + componentType);
		}
	}
	
	@Override
	public int calculateWordLength(AbstractComponent word) throws TextException {
		ComponentType componentType = word.getComponentName();
		if (componentType == ComponentType.WORD) {
			int wordLength = word.getComponentsSize();
			return wordLength;
		} else {
			throw new TextException("Composite type != WORD: " + componentType);
		}
	}
	
	@Override
	public int calculateAllIdenticalWords(AbstractComponent textComposite, String wordToSearch) {
		TextSearchService searchService = new TextSearchServiceImpl();
		List<AbstractComponent> words = searchService.findAllWords(textComposite);
		int wordsCount = 0;
		for (AbstractComponent word: words) {
			String word1 = word.toString().toLowerCase();
			String word2 = wordToSearch.toLowerCase();
			if (word1.equals(word2)) {
				wordsCount++;
			}
		}
		return wordsCount;
	}
	
	@Override
	public int calculateVowelCount(AbstractComponent component) {
		TextSearchService searchService = new TextSearchServiceImpl();
		List<AbstractComponent> letters = searchService.findAllLetters(component);
		int vowelCount = 0;
		for (AbstractComponent letterComponent: letters) {
			String stringToSearch = Character.toString(letterComponent.getContent());
			if (Pattern.matches(VOWEL, stringToSearch)) {
				vowelCount++;
			}
		}
		return vowelCount;
	}
	
	@Override
	public int calculateConsonantCount(AbstractComponent component) {
		TextSearchService searchService = new TextSearchServiceImpl();
		List<AbstractComponent> letters = searchService.findAllLetters(component);
		int consonantCount = 0;
		for (AbstractComponent letterComponent: letters) {
			String stringToSearch = Character.toString(letterComponent.getContent());
			if (Pattern.matches(CONSONANT, stringToSearch)) {
				consonantCount++;
			}
		}
		return consonantCount;
	}
	
}
