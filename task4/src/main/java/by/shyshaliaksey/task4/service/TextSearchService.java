package by.shyshaliaksey.task4.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.TextComposite;
import by.shyshaliaksey.task4.exception.TextException;

public class TextSearchService {

	public List<Integer> findSentencesWithLongestWord(TextComposite textComposite) throws TextException {
		List<Integer> sentencesNumbers = new ArrayList<>();
		Map<AbstractComponent, Integer> words = new HashMap<>();
		allWordsMapTraverse(textComposite, words, 0);
		TextCalculationService calculationService = new TextCalculationService();
		int maxWord = 0;
		for (AbstractComponent component: words.keySet()) {
			int currentLength = calculationService.calculateWordLength((TextComposite)component);
			if (currentLength > maxWord) {
				maxWord = currentLength;
				sentencesNumbers = new ArrayList<>();
 				sentencesNumbers.add(words.get(component));
			} else if (currentLength == maxWord) {
				sentencesNumbers.add(words.get(component));
			}
		}
		return sentencesNumbers;
	}
	
	public List<AbstractComponent> findAllSentences(AbstractComponent textComposite) {
		List<AbstractComponent> sentences = new ArrayList<>();
		allSentencesTraverse((TextComposite) textComposite, sentences);
		return sentences;
	}
	
	public List<AbstractComponent> findAllSymbols(AbstractComponent textComposite) {
		List<AbstractComponent> symbols = new ArrayList<>();
		allSymbolsTraverse((TextComposite)textComposite, symbols);
		return symbols;
	}
	
	public Map<AbstractComponent, Integer> findAllWordsWithSentencesNumbers(TextComposite textComposite) {
		Map<AbstractComponent, Integer> words = new HashMap<>();
		allWordsMapTraverse(textComposite, words, 0);
		return words;
	}
	
	public List<AbstractComponent> findAllWords(TextComposite textComposite) {
		List<AbstractComponent> words = new ArrayList<>();
		allWordsTraverse(textComposite, words);
		return words;
	}
	
	private List<AbstractComponent> allWordsTraverse(TextComposite composite, List<AbstractComponent> words) {
		for (AbstractComponent component: composite.getComponents()) {
			ComponentName componentName = component.getComponentName();
			if (componentName == ComponentName.WORD) {
				words.add(component);
			} else if (componentName != ComponentName.SYMBOL && componentName != ComponentName.DIGIT) {
				allWordsTraverse((TextComposite)component, words);
			}
		}
		return words;
	}
	
	private List<AbstractComponent> allSymbolsTraverse(AbstractComponent composite, List<AbstractComponent> symbols) {
		ComponentName componentName = composite.getComponentName();
		if (componentName == ComponentName.SYMBOL) {
			symbols.add(composite);
			return symbols;
		}
		if (componentName == ComponentName.DIGIT) {
			return symbols;
		}
		for (AbstractComponent component: ((TextComposite)composite).getComponents()) {
			allSymbolsTraverse(component, symbols);
		}
		return symbols;
	}
	
	private List<AbstractComponent> allSentencesTraverse(TextComposite composite, List<AbstractComponent> sentences) {
		for (AbstractComponent component: composite.getComponents()) {
			ComponentName componentName = component.getComponentName();
			if (componentName == ComponentName.SENTENCE) {
				sentences.add(component);
			} else if (componentName == ComponentName.TEXT || componentName == ComponentName.PARAGRAPH) {
				allSentencesTraverse((TextComposite)component, sentences);
			}
		}
		return sentences;
	}
	
	private Map<AbstractComponent, Integer> allWordsMapTraverse(TextComposite composite, Map<AbstractComponent, Integer> words, int currentSentence) {
		for (AbstractComponent component: composite.getComponents()) {
			ComponentName componentName = component.getComponentName();
			if (componentName == ComponentName.WORD) {
				words.put(component, currentSentence);
			} else if (componentName != ComponentName.SYMBOL && componentName != ComponentName.DIGIT) {
				if (componentName == ComponentName.SENTENCE) {
					currentSentence++;
				}
				allWordsMapTraverse((TextComposite)component, words, currentSentence);
			}
		}
		return words;
	}
}
