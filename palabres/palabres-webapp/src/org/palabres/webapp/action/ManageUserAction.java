package org.palabres.webapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.example.palabres.model.bean.utilisateur.Utilisateur;
import org.example.palabres.model.exception.FunctionalException;
import org.example.palabres.model.exception.NotFoundException;
import org.palabres.webapp.helper.WebAppHelper;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class ManageUserAction extends ActionSupport implements ServletRequestAware, SessionAware {

	private static final long serialVersionUID = -7149621975724165813L;

	// Constant to be used to identify session
	private static final String USER = "user";

	// Handling session
	private Map<String, Object> userSession;

	// The bean to be defined for the login form - using corresponding entity
	@Autowired
	private Utilisateur userBean;
	private String password = "1234";

    private HttpServletRequest servletRequest;

	/**
	 * @return the password
	 */
    public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userBean
	 */
	public Utilisateur getUserBean() {
		return userBean;
	}

	/**
	 * @param userBean
	 *            the userBean to set
	 */
	public void setUserBean(Utilisateur userBean) {
		this.userBean = userBean;
	}

	@Override
	public void setSession(Map<String, Object> session) {

		userSession = session;
	}

	/**
	 * Login method checking user sign in
	 * 
	 * @return
	 */
	public String doLogin() {

		// Return input by default :
        String vResult = ActionSupport.INPUT;
        
        
		// Redirect if user already logged in :
		if (this.userSession.containsKey(USER) && null != this.userSession.get(USER)) {
			
			return ActionSupport.SUCCESS;     
		} 
		
		
        
        // Check if we have password and userBean submitted :
        if (userBean != null && userBean.getPseudo() != null && !StringUtils.isAllEmpty(userBean.getPseudo(), password)) {
            try {
            	
            	System.out.println("Retrieving user with pseudo " + userBean.getPseudo());
            	
                Utilisateur vUtilisateur
                        = WebAppHelper.getManagerFactory().getUtilisateurManager()
                                      .getUtilisateur(userBean.getPseudo());

                this.addActionError("You are already there !");
                
            } catch (NotFoundException pEx) {
                //this.addActionError("Identifiant ou mot de passe invalide !");

            	/* Perfect we are all good we should continue now :*/
                
                System.out.println("Adding user to session");
                
                try {
					WebAppHelper.getManagerFactory().getUtilisateurManager().addUtilisateur(userBean);
				} catch (FunctionalException e) {
					e.printStackTrace();
				}
                
                // Ajout de l'utilisateur en session
                this.userSession.put(USER, userBean);
                
                vResult = ActionSupport.SUCCESS;            	
            	
            }
        }
        
        return vResult;
	}

	/**
	 * Action de déconnexion d'un utilisateur
	 * 
	 * @return success
	 */
	public String doLogout() {
		
	    this.userSession.remove(USER);
        // Invalidation de la session
        this.servletRequest.getSession().invalidate();
		return ActionSupport.SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
        this.servletRequest = request;
		
	}
	
	
	/**
	 * Register method 
	 * TODO 
	 * @return
	 */
	public String doRegister() {

		// Return input by default :
        String vResult = ActionSupport.INPUT;
        
        // Check if we have password and userBean submitted :
        if (userBean != null && !StringUtils.isAllEmpty(userBean.getPseudo(), password)) {
        	
            System.out.println("Retrieving user with pseudo " + userBean.getPseudo());
        }
        
        return vResult;
	}
	
}
