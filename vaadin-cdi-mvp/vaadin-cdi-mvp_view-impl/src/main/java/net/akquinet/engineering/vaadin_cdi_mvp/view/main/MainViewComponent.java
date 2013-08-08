/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package net.akquinet.engineering.vaadin_cdi_mvp.view.main;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import net.akquinet.engineering.vaadin_cdi_mvp.view.VaadinView;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;

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
