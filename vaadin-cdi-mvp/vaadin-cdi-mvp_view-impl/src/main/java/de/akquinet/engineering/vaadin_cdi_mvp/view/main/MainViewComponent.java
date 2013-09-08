/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp.view.main;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;


import com.vaadin.ui.Component;
import com.vaadin.ui.Label;

import de.akquinet.engineering.vaadin_cdi_mvp.view.VaadinView;
import de.akquinet.engineering.vaadin_cdi_mvp.view.main.MainView;

/**
 * @author Oliver Damm
 */
@Dependent
public class MainViewComponent implements MainView, VaadinView<Component>
{

	private static final long serialVersionUID = 1L;

	private Label label;

	@PostConstruct
	public void init()
	{
		this.label = new Label("Hello CDI Vaadin!");
	}

	@Override
	public <V> V unwrap(Class<V> type)
	{
		return type.cast(this);
	}

	@Override
	public Label getComponent()
	{
		return this.label;
	}

}
