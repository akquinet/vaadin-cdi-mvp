/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter;

import net.akquinet.engineering.vaadin_cdi_mvp.view.View;

/**
 * @author Oliver Damm
 */
public interface Presenter<V extends View>
{

	public V getView();

}
