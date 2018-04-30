package org.palabres.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ManageUserAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7149621975724165813L;

	// Constant to be used to identify session
	private static final String USER = "USER";

	// Handling session
	private Map<String, Object> userSession ;
	
	// The bean to be defined for the login form - using corresponding entity
	private Utilisateur	userBean;

	@Override
	public void setSession(Map<String, Object> session) {

		userSession = session;
	}
	
	
	/**
	 * Login method checking user sign in
	 * @return
	 */
	public String doLogin() {
		
		// Call service class to retrieve and compare state in database
		
		// Add user to session
		userSession.put(USER, this.userBean);
		
		return ActionSupport.SUCCESS;
}
}
