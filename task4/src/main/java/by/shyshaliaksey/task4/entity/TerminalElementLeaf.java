package by.shyshaliaksey.task4.entity;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TerminalElementLeaf extends AbstractComponent {

	private static Logger logger = LogManager.getRootLogger(); 
	private char content;
	
	public TerminalElementLeaf(ComponentType componentType, AbstractComponent parent, char content) {
		super(componentType, parent);
		this.content = content;
	}
	
	public char getContent() {
		return content;
	}

	@Override
	public void add(AbstractComponent abstractComponent){
		logger.log(Level.ERROR, "UnsupportedOperationException");
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(AbstractComponent abstractComponent){
		logger.log(Level.ERROR, "UnsupportedOperationException");
		throw new UnsupportedOperationException();
	}

	@Override
	public AbstractComponent getChild(int index) {
		logger.log(Level.ERROR, "UnsupportedOperationException");
		throw new UnsupportedOperationException();
	}

	@Override
	public int getComponentsSize() {
		logger.log(Level.ERROR, "UnsupportedOperationException");
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void addAllToList(List<AbstractComponent> abstractComponents) {
		abstractComponents.add(this);
	}
}
