package by.shyshaliaksey.task4.entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractComponent implements Iterable<AbstractComponent> {

	protected ComponentType componentType;
	protected AbstractComponent parent;

	protected AbstractComponent() {
	}

	protected AbstractComponent(ComponentType componentType, AbstractComponent parent) {
		this.componentType = componentType;
		this.parent = parent;
	}

	public Iterator<AbstractComponent> iterator() {
		List<AbstractComponent> list = new LinkedList<>();
		addAllToList(list);
		list.add(this);
		return list.iterator();
	}

	public ComponentType getComponentName() {
		return this.componentType;
	}

	public abstract int getComponentsSize();

	public AbstractComponent getParent() {
		return this.parent;
	}

	public abstract char getContent();

	public abstract void add(AbstractComponent abstractComponent);

	public abstract void remove(AbstractComponent abstractComponent);

	public abstract AbstractComponent getChild(int index);

	public abstract void addAllToList(List<AbstractComponent> abstractComponents);

}
