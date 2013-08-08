/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.toolbar;

import net.akquinet.engineering.vaadin_cdi_mvp.view.ObservableView;

/**
 * @author Oliver Damm
 */
public interface ContactToolbarView extends ObservableView<ContactToolbarViewObserver>
{

	public void enableButtonCreate(boolean enabled);

	public void enableButtonEdit(boolean enabled);

	public void enableButtonDelete(boolean enabled);

}
