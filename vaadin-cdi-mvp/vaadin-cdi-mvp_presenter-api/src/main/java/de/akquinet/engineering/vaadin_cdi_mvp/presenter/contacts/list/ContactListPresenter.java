/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.list;

import net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.list.ContactListView;
import de.akquinet.engineering.vaadin_cdi_mvp.presenter.Presenter;

/**
 * @author Oliver Damm
 */
public interface ContactListPresenter extends Presenter<ContactListView>
{

	public void selectContact(Long id);

	public Long getSelectedContact();

}
