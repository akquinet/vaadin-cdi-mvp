/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.toolbar;

import javax.inject.Inject;

import net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.toolbar.ContactToolbarView;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.junit.NeedleRule;

/**
 * @author Oliver Damm
 */
public class ContactToolbarPresenterBeanTest
{

	@Rule
	public NeedleRule needleRule = new NeedleRule();

	@Inject
	private ContactToolbarView view;

	@ObjectUnderTest
	private ContactToolbarPresenterBean presenter;

	@Test
	public void testEnableButtons()
	{
		this.presenter.enableButtons(true, true, false);

		Mockito.verify(this.view).enableButtonCreate(true);
		Mockito.verify(this.view).enableButtonEdit(true);
		Mockito.verify(this.view).enableButtonDelete(false);
		Mockito.verifyNoMoreInteractions(this.view);
	}

}
