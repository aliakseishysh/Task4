package by.shyshaliaksey.task4.parser;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentName;
import by.shyshaliaksey.task4.entity.LeafElement;
import by.shyshaliaksey.task4.exception.TextException;

public abstract class Chain {

	private static final String DIGITS = "0123456789";
	private static final String PUNCTUATION_MARKS = ".,-!?…"; 
	
	protected Chain nextInChain;
	
	public void setNextInChain(Chain nextInChain) {
		this.nextInChain = nextInChain;
	}

	public abstract void parse(AbstractComponent parentComponent, String contentToParse) throws TextException;

	protected void parseSymbols(AbstractComponent component, String stringToParse) {
		if (stringToParse != null) {
			for (char symbol : stringToParse.toCharArray()) {
				ComponentName componentName = ComponentName.SYMBOL;
				if (DIGITS.contains(Character.toString(symbol))) {
					componentName = ComponentName.DIGIT;
				} else if (PUNCTUATION_MARKS.contains(Character.toString(symbol))) {
					componentName = ComponentName.PUNCTUATION_MARK;
				}
				component.add(new LeafElement(componentName, component, symbol));
			}
		}
	}
	
}
