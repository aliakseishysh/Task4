package by.shyshaliaksey.task4.entity;

import by.shyshaliaksey.task4.exception.TextException;

public class Element extends Component {

	public Element(ComponentName componentName, String content) {
		super(componentName, content);
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
	public void add(Component component) throws TextException {
		throw new TextException("Unsupported Operation");
	}

	@Override
	public void remove(Component component) throws TextException {
		throw new TextException("Unsupported Operation");
	}

	@Override
	public Object getChild(int index) throws TextException {
		throw new TextException("Unsupported Operation");
	}

}
