package by.shyshaliaksey.task4.entity;

import java.util.ArrayList;
import java.util.List;

import by.shyshaliaksey.task4.exception.TextException;

public class TextComposite extends AbstractComponent {

	private List<AbstractComponent> abstractComponents;
	
	public TextComposite() {
		super();
	}
	
	public TextComposite(ComponentName componentName) {
		super(componentName);
		abstractComponents = new ArrayList<>();
	}
	
	@Override
	public String getContent() throws TextException {
		throw new TextException("Unsupported Operation");
	}
	
	@Override
	public void operation() throws TextException {
		for (AbstractComponent abstractComponent : abstractComponents) {
			abstractComponent.operation();
		}
	}
	
	@Override
	public void add(AbstractComponent abstractComponent) {
		abstractComponents.add(abstractComponent);
	}

	@Override
	public void remove(AbstractComponent abstractComponent) {
		abstractComponents.remove(abstractComponent);
	}

	@Override
	public AbstractComponent getChild(int index) {
		return abstractComponents.get(index);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		try {
			return traverse(this, builder).toString();
		} catch (TextException e) {
			// TODO add log
			return builder.toString();
		}
	}
	
	private StringBuilder traverse(TextComposite composite, StringBuilder builder) throws TextException {
		for (AbstractComponent element: composite.abstractComponents) {
			Class elementClass = element.getClass();
			if (elementClass == Element.class) {
				builder.append(element.getContent());
			} else if (elementClass == TextComposite.class) {
				traverse((TextComposite)element, builder);
			}
		}
		return builder;
	}

}
