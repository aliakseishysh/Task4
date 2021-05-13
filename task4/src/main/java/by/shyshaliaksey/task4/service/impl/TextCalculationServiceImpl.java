package by.shyshaliaksey.task4.service.impl;

import java.util.List;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.LeafElement;
import by.shyshaliaksey.task4.exception.TextException;
import by.shyshaliaksey.task4.service.TextCalculationService;
import by.shyshaliaksey.task4.service.TextSearchService;

public class TextCalculationServiceImpl implements TextCalculationService {
	
	private static final String VOWELS = "aeiou";
	private static final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";

	@Override
	public int calculateSentencesInParagraph(AbstractComponent paragraph) throws TextException {
		ComponentName componentName = paragraph.getComponentName();
		if (componentName == ComponentName.PARAGRAPH) {
			int sentenceCount = paragraph.getComponentsSize();
			return sentenceCount;
		} else {
			throw new TextException("Composite type != PARAGRAPH: " + componentName);
		}
	}
	
	@Override
	public int calculateWordLength(AbstractComponent word) throws TextException {
		ComponentName componentName = word.getComponentName();
		if (componentName == ComponentName.WORD) {
			int wordLength = word.getComponentsSize();
			return wordLength;
		} else {
			throw new TextException("Composite type != WORD: " + componentName);
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
		List<AbstractComponent> symbols = searchService.findAllSymbols(component);
		int vowelCount = 0;
		for (AbstractComponent symbolComponent: symbols) {
			LeafElement leafElement = (LeafElement) symbolComponent;
			String stringToSearch = Character.toString(leafElement.getContent()).toLowerCase();
			if (VOWELS.contains(stringToSearch)) {
				vowelCount++;
			}
		}
		return vowelCount;
	}
	
	@Override
	public int calculateConsonantCount(AbstractComponent component) {
		TextSearchService searchService = new TextSearchServiceImpl();
		List<AbstractComponent> symbols = searchService.findAllSymbols(component);
		int consonantCount = 0;
		for (AbstractComponent symbolComponent: symbols) {
			LeafElement leafElement = (LeafElement) symbolComponent;
			String stringToSearch = Character.toString(leafElement.getContent()).toLowerCase();
			if (CONSONANTS.contains(stringToSearch)) {
				consonantCount++;
			}
		}
		return consonantCount;
	}
	
}
