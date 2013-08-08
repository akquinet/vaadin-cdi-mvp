/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package net.akquinet.engineering.vaadin_cdi_mvp.view.contacts.editor;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import net.akquinet.engineering.vaadin_cdi_mvp.view.VaadinView;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Oliver Damm
 */
@Dependent
public class ContactEditorViewComponent extends VerticalLayout implements ContactEditorView, VaadinView<Component>
{

	private static final long serialVersionUID = 1L;

	private ContactEditorViewObserver observer;
	private TextField textFieldFirstname;
	private TextField textFieldLastname;
	private TextField textFieldEmail;
	private Button buttonApply;
	private Button buttonCancel;

	@PostConstruct
	public void init()
	{
		this.textFieldFirstname = new TextField("Vorname");
		this.textFieldLastname = new TextField("Nachname");

		this.textFieldEmail = new TextField("E-Mail");
		this.textFieldEmail.setWidth("100%");

		this.buttonApply = new Button("Übernehmen");
		this.buttonApply.addClickListener(new ButtonApplyClickedListener());

		this.buttonCancel = new Button("Abbrechen");
		this.buttonCancel.addClickListener(new ButtonCancelClickedListener());

		HorizontalLayout layoutName = new HorizontalLayout();
		layoutName.setSpacing(true);
		layoutName.addComponent(this.textFieldFirstname);
		layoutName.addComponent(this.textFieldLastname);

		HorizontalLayout layoutButtons = new HorizontalLayout();
		layoutButtons.setWidth("100%");
		layoutButtons.setSpacing(true);
		layoutButtons.addComponent(this.buttonApply);
		layoutButtons.addComponent(this.buttonCancel);
		layoutButtons.setExpandRatio(this.buttonApply, 1f);
		layoutButtons.setComponentAlignment(this.buttonApply, Alignment.MIDDLE_RIGHT);

		setSpacing(true);
		setMargin(new MarginInfo(false, false, false, true));
		setWidth(null);
		addComponent(layoutName);
		addComponent(this.textFieldEmail);
		addComponent(layoutButtons);
	}

	@Override
	public <V> V unwrap(Class<V> type)
	{
		return type.cast(this);
	}

	@Override
	public void setObserver(ContactEditorViewObserver observer)
	{
		this.observer = observer;
	}

	public void setFirstname(String firstname)
	{
		this.textFieldFirstname.setValue(firstname);
	}

	public String getFirstname()
	{
		return this.textFieldFirstname.getValue();
	}

	public void setLastname(String lastname)
	{
		this.textFieldLastname.setValue(lastname);
	}

	public String getLastname()
	{
		return this.textFieldLastname.getValue();
	}

	public void setEmail(String email)
	{
		this.textFieldEmail.setValue(email);
	}

	public String getEmail()
	{
		return this.textFieldEmail.getValue();
	}

	public void setEnabled(boolean enabled)
	{
		this.textFieldFirstname.setEnabled(enabled);
		this.textFieldLastname.setEnabled(enabled);
		this.textFieldEmail.setEnabled(enabled);
		this.buttonApply.setEnabled(enabled);
		this.buttonCancel.setEnabled(enabled);
	}

	public void setVisible(boolean visible)
	{
		super.setVisible(visible);
	}

	@Override
	public Component getComponent()
	{
		return this;
	}

	private void buttonApplyClicked()
	{
		if (this.observer != null)
		{
			this.observer.buttonApplyClicked();
		}
	}

	private void buttonCancelClicked()
	{
		if (this.observer != null)
		{
			this.observer.buttonCancelClicked();
		}
	}

	private class ButtonApplyClickedListener implements ClickListener
	{

		private static final long serialVersionUID = 1L;

		@Override
		public void buttonClick(ClickEvent event)
		{
			buttonApplyClicked();
		}

	}

	private class ButtonCancelClickedListener implements ClickListener
	{

		private static final long serialVersionUID = 1L;

		@Override
		public void buttonClick(ClickEvent event)
		{
			buttonCancelClicked();
		}
	}

}
