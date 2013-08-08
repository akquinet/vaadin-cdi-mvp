/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.toolbar;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import de.akquinet.engineering.vaadin_cdi_mvp.events.CreateContactRequestedEvent;
import de.akquinet.engineering.vaadin_cdi_mvp.events.DeleteContactRequestedEvent;
import de.akquinet.engineering.vaadin_cdi_mvp.events.EditContactRequestedEvent;
import de.akquinet.engineering.vaadin_cdi_mvp.presenter.Discriminator;

/**
 * @author Oliver Damm
 */
@SessionScoped
@Discriminator("usecase2")
public class AlternativeContactToolbarPresenterBean extends AbstractContactToolbarPresenterBean
{

	private static final long serialVersionUID = 1L;

	@Inject
	@Discriminator("usecase2")
	private Event<CreateContactRequestedEvent> createContactRequestedEvent;

	@Inject
	@Discriminator("usecase2")
	private Event<EditContactRequestedEvent> editContactRequestedEvent;

	@Inject
	@Discriminator("usecase2")
	private Event<DeleteContactRequestedEvent> deleteContactRequestedEvent;

	@Override
	protected Event<CreateContactRequestedEvent> getCreateContactRequestedEvent()
	{
		return this.createContactRequestedEvent;
	}

	@Override
	protected Event<EditContactRequestedEvent> getEditContactRequestedEvent()
	{
		return this.editContactRequestedEvent;
	}

	@Override
	protected Event<DeleteContactRequestedEvent> getDeleteContactRequestedEvent()
	{
		return this.deleteContactRequestedEvent;
	}

}
