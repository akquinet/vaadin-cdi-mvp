/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.editor;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import de.akquinet.engineering.vaadin_cdi_mvp.events.ContactEditingCanceled;
import de.akquinet.engineering.vaadin_cdi_mvp.events.ContactEditingFinished;
import de.akquinet.engineering.vaadin_cdi_mvp.model.contact.Contact;
import de.akquinet.engineering.vaadin_cdi_mvp.model.contact.ContactModel;
import de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.editor.ContactEditorView;
import de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.editor.ContactEditorViewObserver;

/**
 * @author Oliver Damm
 */
@SessionScoped
public class ContactEditorPresenterBean implements ContactEditorPresenter, ContactEditorViewObserver, Serializable
{

	private static final long serialVersionUID = 1L;

	private Long contactId;

	@Inject
	private ContactEditorView view;

	@Inject
	private ContactModel contactModel;

	@Inject
	private Event<ContactEditingFinished> contactEditingFinishedEvent;

	@Inject
	private Event<ContactEditingCanceled> contactEditingCanceledEvent;

	@PostConstruct
	public void init()
	{
		this.contactId = null;

		this.view.setObserver(this);
		this.view.setVisible(false);
	}

	@Override
	public ContactEditorView getView()
	{
		return this.view;
	}

	@Override
	public void setContact(Contact contact)
	{
		if (contact != null)
		{
			this.contactId = contact.getId();

			this.view.setFirstname(contact.getFirstname());
			this.view.setLastname(contact.getLastname());
			this.view.setEmail(contact.getEmail());
		}
		else
		{
			this.contactId = null;

			this.view.setFirstname("");
			this.view.setLastname("");
			this.view.setEmail("");
		}
	}

	@Override
	public void setStates(boolean visible, boolean enabled)
	{
		this.view.setVisible(visible);
		this.view.setEnabled(enabled);

	}

	@Override
	public void buttonApplyClicked()
	{
		this.view.setEnabled(false);

		String firstname = this.view.getFirstname();
		String lastname = this.view.getLastname();
		String email = this.view.getEmail();

		Long id = this.contactModel.createOrUpdateContact(this.contactId, firstname, lastname, email);

		this.contactEditingFinishedEvent.fire(new ContactEditingFinished(id));
	}

	@Override
	public void buttonCancelClicked()
	{
		this.view.setVisible(false);

		this.contactEditingCanceledEvent.fire(new ContactEditingCanceled(this.contactId));
	}

}
