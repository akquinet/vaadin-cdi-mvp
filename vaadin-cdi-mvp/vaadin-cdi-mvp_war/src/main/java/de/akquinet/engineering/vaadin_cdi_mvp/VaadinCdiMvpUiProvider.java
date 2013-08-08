/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;

/**
 * @author Oliver Damm
 */
@SessionScoped
public class VaadinCdiMvpUiProvider extends UIProvider
{

	private static final long serialVersionUID = 1L;

	@Inject
	private VaadinCdiMvpUI ui;

	@Override
	public Class<? extends UI> getUIClass(UIClassSelectionEvent event)
	{
		return VaadinCdiMvpUI.class;
	}

	@Override
	public UI createInstance(UICreateEvent event)
	{
		return this.ui;
	}

}
