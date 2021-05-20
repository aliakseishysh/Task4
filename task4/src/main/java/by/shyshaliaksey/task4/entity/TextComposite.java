package by.shyshaliaksey.task4.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextComposite extends AbstractComponent {

	private static Logger logger = LogManager.getRootLogger(); 
	private List<AbstractComponent> components;
	
	public TextComposite() {
		super();
	}
	
	public TextComposite(ComponentName componentName, AbstractComponent parent) {
		super(componentName, parent);
		this.components = new ArrayList<>();
	}
	
	public int getComponentsSize() {
		return components.size();
	}
	
	public void setComponents(List<AbstractComponent> components) {
		this.components = new ArrayList<>(components);
	}
	
	@Override
	public char getContent() {
		logger.log(Level.ERROR, "UnsupportedOperationException");
		throw new UnsupportedOperationException();
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
		for (AbstractComponent component: this) {
			ComponentName componentName = component.getComponentName();
			if (componentName == ComponentName.SYMBOL
					|| componentName == ComponentName.LETTER
					|| componentName == ComponentName.DIGIT
					|| componentName == ComponentName.PUNCTUATION_MARK) {
				builder.append(component.getContent());
			}
		}
		return builder.toString();
	}

	@Override
	protected void addAllToList(List<AbstractComponent> abstractComponents) {
		for (AbstractComponent component : this.components) {
			ComponentName componentName = component.getComponentName();
			if (componentName == ComponentName.SYMBOL
					|| componentName == ComponentName.LETTER
					|| componentName == ComponentName.DIGIT
					|| componentName == ComponentName.PUNCTUATION_MARK) {
				abstractComponents.add(component);
			} else {
				abstractComponents.add(component);
				component.addAllToList(abstractComponents);
			}
		}
	}
	
}
