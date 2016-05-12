package es.uned.mexposito37.daoo.model;

import java.beans.PropertyChangeListener;

public interface AbstractModelObjectInterface {

	public void addPropertyChangeListener(PropertyChangeListener listener);
	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener);

	public void removePropertyChangeListener(PropertyChangeListener listener);

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener);
}
