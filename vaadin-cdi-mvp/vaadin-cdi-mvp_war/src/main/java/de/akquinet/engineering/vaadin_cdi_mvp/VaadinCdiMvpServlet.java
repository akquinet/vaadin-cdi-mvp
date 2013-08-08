/*
 * Vaadin + CDI = MVP 
 * (c) 2013 akquinet AG, Paul-Stritter-Weg 5, 22297 Hamburg
 */
package de.akquinet.engineering.vaadin_cdi_mvp;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;

/**
 * @author Oliver Damm
 */
@WebServlet(name = "VaadinCdiMvpServlet", urlPatterns = "/*")
public class VaadinCdiMvpServlet extends VaadinServlet implements SessionInitListener, SessionDestroyListener
{

	private static final long serialVersionUID = 1L;

	@Inject
	private VaadinCdiMvpUiProvider uiProvider;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException
	{
		super.init(servletConfig);
		getService().addSessionInitListener(this);
		getService().addSessionDestroyListener(this);
	}

	@Override
	public void sessionInit(SessionInitEvent event) throws ServiceException
	{
		event.getSession().addUIProvider(this.uiProvider);
	}

	@Override
	public void sessionDestroy(SessionDestroyEvent event)
	{
		event.getSession().getSession().invalidate();
	}

}
