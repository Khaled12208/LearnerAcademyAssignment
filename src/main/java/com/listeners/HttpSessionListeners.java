package com.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener ;

/**
 * Application Lifecycle Listener implementation class AppContextListener
 *
 */
@WebListener
public class HttpSessionListeners implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public HttpSessionListeners() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	
    	System.out.println("session created");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("session destroyed");
    }
	
}
