package by.shyshaliaksey.task4.entity;

import java.util.ArrayList;
import java.util.List;

import by.shyshaliaksey.task4.exception.TextException;

public class TextComposite extends AbstractComponent {

	private List<AbstractComponent> components;
	
	public TextComposite() {
		super();
	}
	
	public TextComposite(ComponentName componentName, AbstractComponent parent) {
		super(componentName, parent);
		this.components = new ArrayList<>();
	}
	
	public List<AbstractComponent> getComponents() {
		return components;
	}
	
	public void setChild(int index, AbstractComponent component) {
		components.set(index, component);
	}
	
	@Override
	public char getContent() throws TextException {
		throw new TextException("Unsupported Operation");
	}

	@Override
	public void add(AbstractComponent component) {
		components.add(component);
	}

	@Override
	public void remove(AbstractComponent component) {
		components.remove(component);
	}

	@Override
	public AbstractComponent getChild(int index) {
		return components.get(index);
	}
	
	@Override
	public TextComposite clone() throws CloneNotSupportedException {
		return (TextComposite) super.clone();
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
		for (AbstractComponent component: composite.components) {
			ComponentName componentName = component.getComponentName();
			if (componentName == ComponentName.SYMBOL || componentName == ComponentName.DIGIT) {
				builder.append(component.getContent());
			} else {
				traverse((TextComposite)component, builder);
			}
		}
		return builder;
	}

}
