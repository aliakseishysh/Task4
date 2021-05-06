package by.shyshaliaksey.task4.entity;

import by.shyshaliaksey.task4.exception.TextException;

public class Element extends AbstractComponent {

	private char content;
	
	public Element(ComponentName componentName, char content) {
		super(componentName);
		this.content = content;
	}
	
	@Override
	public char getContent() throws TextException {
		return content;
	}

	@Override
	public void add(AbstractComponent abstractComponent) throws TextException {
		throw new TextException("Unsupported Operation");
	}

	@Override
	public void remove(AbstractComponent abstractComponent) throws TextException {
		throw new TextException("Unsupported Operation");
	}

	@Override
	public AbstractComponent getChild(int index) throws TextException {
		throw new TextException("Unsupported Operation");
	}

	

}
