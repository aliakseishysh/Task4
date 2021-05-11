package by.shyshaliaksey.task4.service;

import java.util.List;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.entity.Symbol;
import by.shyshaliaksey.task4.exception.TextException;

public class TextCalculationService {
	
	private static final String VOWELS = "aeiou";
	private static final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";

	public int calculateSentencesInParagraph(TextComposite paragraph) throws TextException {
		if (paragraph.getComponentName() == ComponentName.PARAGRAPH) {
			int sentenceCount = paragraph.getComponents().size();
			return sentenceCount;
		} else {
			throw new TextException("Composite type != PARAGRAPH: " + paragraph.getComponentName());
		}
	}
	
	public int calculateWordLength(TextComposite word) throws TextException {
		if (word.getComponentName() == ComponentName.WORD) {
			int wordLength = word.getComponents().size();
			return wordLength;
		} else {
			throw new TextException("Composite type != WORD: " + word.getComponentName());
		}
	}
	
	public int calculateAllIdenticalWords(TextComposite textComposite, String wordToSearch) {
		TextSearchService searchService = new TextSearchService();
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
	
	public int calculateVowelCount(AbstractComponent component) throws TextException {
		TextSearchService searchService = new TextSearchService();
		List<AbstractComponent> symbols = searchService.findAllSymbols(component);
		int vowelCount = 0;
		for (AbstractComponent symbolComponent: symbols) {
			Symbol symbol = (Symbol) symbolComponent;
			String stringToSearch = Character.toString(symbol.getContent()).toLowerCase();
			if (VOWELS.contains(stringToSearch)) {
				vowelCount++;
			}
		}
		return vowelCount;
	}
	
	public int calculateConsonantCount(AbstractComponent component) throws TextException {
		TextSearchService searchService = new TextSearchService();
		List<AbstractComponent> symbols = searchService.findAllSymbols(component);
		int consonantCount = 0;
		for (AbstractComponent symbolComponent: symbols) {
			Symbol symbol = (Symbol) symbolComponent;
			String stringToSearch = Character.toString(symbol.getContent()).toLowerCase();
			if (CONSONANTS.contains(stringToSearch)) {
				consonantCount++;
			}
		}
		return consonantCount;
	}
	
}
