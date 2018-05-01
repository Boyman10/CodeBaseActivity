package org.palabres.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.example.palabres.model.bean.utilisateur.Utilisateur;
import org.example.palabres.model.exception.NotFoundException;
import org.palabres.webapp.helper.WebAppHelper;
import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class ManageUserAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7149621975724165813L;

	// Constant to be used to identify session
	private static final String USER = "USER";

	// Handling session
	private Map<String, Object> userSession;

	// The bean to be defined for the login form - using corresponding entity
	private Utilisateur userBean;
	private String password = "1234";

	/**
	 * @return the password
	 */
	private String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	private void setPassword(String password) {
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

        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(userBean.getPseudo(), password)) {
            try {
                Utilisateur vUtilisateur
                        = WebAppHelper.getManagerFactory().getUtilisateurManager()
                                      .getUtilisateur(userBean.getPseudo());
                
                // Ajout de l'utilisateur en session
                this.userSession.put(USER, vUtilisateur);
                
                vResult = ActionSupport.SUCCESS;
            } catch (NotFoundException pEx) {
                this.addActionError("Identifiant ou mot de passe invalide !");
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

		return ActionSupport.SUCCESS;
	}
}
