package by.shyshaliaksey.task4.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.exception.TextException;
import by.shyshaliaksey.task4.service.TextCalculationService;
import by.shyshaliaksey.task4.service.TextSearchService;

public class TextSearchServiceImpl implements TextSearchService {
	
	@Override
	public List<AbstractComponent> findAllSentences(AbstractComponent textComposite) {
		List<AbstractComponent> sentences = new ArrayList<>();
		for (AbstractComponent component: textComposite) {
			ComponentName componentName = component.getComponentName();
			if (componentName == ComponentName.SENTENCE) {
				sentences.add(component);
			}
		}
		return sentences;
	}
	
	@Override
	public List<Integer> findSentencesWithLongestWord(AbstractComponent textComposite) throws TextException {
		List<Integer> sentencesNumbers = new ArrayList<>();
		int currentSentence = 0;
		int maxWord = 0;
		TextCalculationService calculationService = new TextCalculationServiceImpl();
		for (AbstractComponent component: textComposite) {
			ComponentName componentName = component.getComponentName();
			if (componentName == ComponentName.SENTENCE) {
				currentSentence++;
			}
			if (componentName == ComponentName.WORD) {
				int currentLength = calculationService.calculateWordLength(component);
				if (currentLength > maxWord) {
					maxWord = currentLength;
					sentencesNumbers = new ArrayList<>();
	 				sentencesNumbers.add(currentSentence);
				} else if (currentLength == maxWord) {
					sentencesNumbers.add(currentSentence);
				}
			}
		}
		return sentencesNumbers;
	}
	
	@Override
	public List<AbstractComponent> findAllWords(AbstractComponent textComposite) {
		List<AbstractComponent> words = new ArrayList<>();
		for (AbstractComponent component: textComposite) {
			ComponentName componentName = component.getComponentName();
			if (componentName == ComponentName.WORD) {
				words.add(component);
			}
		}
		return words;
	}
	
	@Override
	public List<AbstractComponent> findAllSymbols(AbstractComponent textComposite) {
		List<AbstractComponent> symbols = new ArrayList<>();
		for (AbstractComponent component: textComposite) {
			ComponentName componentName = component.getComponentName();
			if (componentName == ComponentName.SYMBOL) {
				symbols.add(component);
			}
		}
		return symbols;
	}
	
	@Override
	public Map<AbstractComponent, Integer> findAllWordsWithSentencesNumbers(AbstractComponent textComposite) {
		Map<AbstractComponent, Integer> words = new HashMap<>();
		int currentSentence = 0;
		for (AbstractComponent component: textComposite) {
			ComponentName componentName = component.getComponentName();
			if (componentName == ComponentName.WORD) {
				words.put(component, currentSentence);
			}
			if (componentName == ComponentName.SENTENCE) {
				currentSentence++;
			}
		}
		return words;
	}
	
}
