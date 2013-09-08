/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.presenter.main;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import de.akquinet.engineering.vaadin_cdi_mvp.view.main.MainView;


/**
 * @author Oliver Damm
 */
@SessionScoped
public class MainPresenterBean implements MainPresenter, Serializable
{

	private static final long serialVersionUID = 1L;

	@Inject
	private MainView view;

	@Override
	public MainView getView()
	{
		return this.view;
	}

}
