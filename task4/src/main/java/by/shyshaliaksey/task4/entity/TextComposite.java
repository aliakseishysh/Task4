package by.shyshaliaksey.task4.entity;

import java.util.ArrayList;
import java.util.List;

import by.shyshaliaksey.task4.exception.TextException;

public class TextComposite extends Component {

	private List<Component> components;
	
	public TextComposite() {
		super();
	}
	
	public TextComposite(ComponentName componentName) {
		super(componentName);
		components = new ArrayList<>();
	}
	
	@Override
	public String getContent() throws TextException {
		throw new TextException("Unsupported Operation");
	}
	
	@Override
	public void operation() throws TextException {
		for (Component component : components) {
			component.operation();
		}
	}
	
	@Override
	public void add(Component component) {
		components.add(component);
	}

	@Override
	public void remove(Component component) {
		components.remove(component);
	}

	@Override
	public Object getChild(int index) {
		return components.get(index);
	}

}
