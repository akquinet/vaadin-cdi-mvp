/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;


import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import de.akquinet.engineering.vaadin_cdi_mvp.presenter.contacts.ContactsPresenter;
import de.akquinet.engineering.vaadin_cdi_mvp.view.VaadinView;

/**
 * @author Oliver Damm
 */
@PreserveOnRefresh
@Dependent
public class VaadinCdiMvpUI extends UI
{

	private static final long serialVersionUID = 1L;

	@Inject
	private ContactsPresenter contactsPresenter;

	@Override
	protected void init(VaadinRequest request)
	{
		setSizeFull();
		setContent(this.contactsPresenter.getView().unwrap(VaadinView.class).getComponent());
	}

}
