/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.toolbar;

import de.akquinet.engineering.vaadin_cdi_mvp.presenter.Presenter;
import de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.toolbar.ContactToolbarView;

/**
 * @author Oliver Damm
 */
public interface ContactToolbarPresenter extends Presenter<ContactToolbarView>
{

	public void enableButtons(boolean createEnabled, boolean editEnabled, boolean deleteEnabled);

}
