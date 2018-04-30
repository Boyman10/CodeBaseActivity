package org.palabres.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ManageUserAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7149621975724165813L;

	// Handling session
	private Map<String, Object> userSession ;

	@Override
	public void setSession(Map<String, Object> session) {

		userSession = session;
	}

}
