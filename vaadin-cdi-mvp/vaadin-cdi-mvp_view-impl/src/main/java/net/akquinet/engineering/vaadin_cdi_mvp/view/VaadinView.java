/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package net.akquinet.engineering.vaadin_cdi_mvp.view;

import com.vaadin.ui.Component;

/**
 * @author Oliver Damm
 */
public interface VaadinView<C extends Component>
{

	public C getComponent();

}
