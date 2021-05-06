package by.shyshaliaksey.task4.entity;

import by.shyshaliaksey.task4.exception.TextException;

public class Element extends AbstractComponent {

	private String content;
	
	public Element(ComponentName componentName, String content) {
		super(componentName);
		this.content = content;
	}
	
	@Override
	public String getContent() throws TextException {
		return content;
	}

	@Override
	public void operation() throws TextException {
		switch (this.componentName) {
		case TEXT:
			throw new TextException("Unsupported Operation");
		case PARAGRAPH:
			throw new TextException("Unsupported Operation");
		case SENTENCE:
			throw new TextException("Unsupported Operation");
		case WORD:
			throw new TextException("Unsupported Operation");
		case LETTER:
			throw new TextException("Unsupported Operation");
		case EXPRESSION:
			throw new TextException("Unsupported Operation");
		case DIGIT:
			throw new TextException("Unsupported Operation");
		case SYMBOL:
			throw new TextException("Unsupported Operation");
		default:
			throw new TextException("Unsupported Operation");
		}
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
	public Object getChild(int index) throws TextException {
		throw new TextException("Unsupported Operation");
	}

	

}
