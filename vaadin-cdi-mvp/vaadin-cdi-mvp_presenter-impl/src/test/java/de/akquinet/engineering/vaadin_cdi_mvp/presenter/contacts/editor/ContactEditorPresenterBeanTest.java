/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.editor;

import javax.enterprise.event.Event;
import javax.inject.Inject;


import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import de.akquinet.engineering.vaadin_cdi_mvp.events.ContactEditingFinished;
import de.akquinet.engineering.vaadin_cdi_mvp.model.contact.ContactModel;
import de.akquinet.engineering.vaadin_cdi_mvp.view.contacts.editor.ContactEditorView;
import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.junit.NeedleRule;

/**
 * @author Oliver Damm
 */
public class ContactEditorPresenterBeanTest
{

	@Rule
	public NeedleRule rule = new NeedleRule();

	@Inject
	private ContactEditorView view;

	@Inject
	private ContactModel model;

	@Inject
	private Event<ContactEditingFinished> event;

	@ObjectUnderTest
	private ContactEditorPresenterBean presenter;

	@Test
	public void testApplyClicked()
	{
		Mockito.when(this.view.getFirstname()).thenReturn("First");
		Mockito.when(this.view.getLastname()).thenReturn("Last");
		Mockito.when(this.view.getEmail()).thenReturn("Email");
		Mockito.when(
				this.model.createOrUpdateContact(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString(),
						Mockito.anyString())).thenReturn(Long.valueOf(1));

		this.presenter.buttonApplyClicked();

		Mockito.verify(this.model).createOrUpdateContact(null, "First", "Last", "Email");
		Mockito.verify(this.event).fire(
				Mockito.argThat(Matchers.allOf(Matchers.isA(ContactEditingFinished.class),
						Matchers.hasProperty("id", Matchers.equalTo(Long.valueOf(1))))));
		Mockito.verifyNoMoreInteractions(this.model, this.event);
	}

}
