/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.view;

import java.io.Serializable;

/**
 * @author Oliver Damm
 */
public interface View extends Serializable
{

	public <T> T unwrap(Class<T> type);

}
