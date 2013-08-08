/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.editor;

import net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.editor.ContactEditorView;
import de.akquinet.engineering.vaadin_cdi_mvp.model.contact.Contact;
import de.akquinet.engineering.vaadin_cdi_mvp.presenter.Presenter;

/**
 * @author Oliver Damm
 */
public interface ContactEditorPresenter extends Presenter<ContactEditorView>
{

	public void setContact(Contact contact);

	public void setStates(boolean visible, boolean enabled);

}
