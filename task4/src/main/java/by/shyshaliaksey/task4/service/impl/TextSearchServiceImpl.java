package by.shyshaliaksey.task4.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.exception.TextException;
import by.shyshaliaksey.task4.service.TextCalculationService;
import by.shyshaliaksey.task4.service.TextSearchService;

public class TextSearchServiceImpl implements TextSearchService {
	
	@Override
	public List<AbstractComponent> findAllSentences(AbstractComponent textComposite) {
		List<AbstractComponent> sentences = new ArrayList<>();
		for (AbstractComponent component: textComposite) {
			ComponentType componentType = component.getComponentName();
			if (componentType == ComponentType.SENTENCE) {
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
			ComponentType componentType = component.getComponentName();
			if (componentType == ComponentType.SENTENCE) {
				currentSentence++;
			}
			if (componentType == ComponentType.WORD) {
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
			ComponentType componentType = component.getComponentName();
			if (componentType == ComponentType.WORD) {
				words.add(component);
			}
		}
		return words;
	}
	
	@Override
	public List<AbstractComponent> findAllLetters(AbstractComponent textComposite) {
		List<AbstractComponent> letters = new ArrayList<>();
		for (AbstractComponent component: textComposite) {
			ComponentType componentType = component.getComponentName();
			if (componentType == ComponentType.LETTER) {
				letters.add(component);
			}
		}
		return letters;
	}
	
	@Override
	public Map<AbstractComponent, Integer> findAllWordsWithSentencesNumbers(AbstractComponent textComposite) {
		Map<AbstractComponent, Integer> words = new HashMap<>();
		int currentSentence = 0;
		for (AbstractComponent component: textComposite) {
			ComponentType componentType = component.getComponentName();
			if (componentType == ComponentType.WORD) {
				words.put(component, currentSentence);
			}
			if (componentType == ComponentType.SENTENCE) {
				currentSentence++;
			}
		}
		return words;
	}
	
}
