package org.palabres.webapp.action;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.palabres.business.contract.ManagerFactory;
import org.example.palabres.model.bean.chat.Channel;
import org.palabres.webapp.helper.WebAppHelper;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class ChannelAction extends ActionSupport {

	private static final long serialVersionUID = -867222532599970697L;
	/** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(ChannelAction.class);

	private List<Channel> arrChannels;
	
    @Autowired
    private ManagerFactory managerFactory;
    
	/**
	 * @return the arrChannels
	 */
	public List<Channel> getArrChannels() {
		return arrChannels;
	}

	/**
	 * @param arrChannels the arrChannels to set
	 */
	public void setArrChannels(List<Channel> arrChannels) {
		this.arrChannels = arrChannels;
	}

	/**
	 * Chat - listing rooms
	 * only if connected
	 * @return
	 */
	public String chat() {
		
		LOGGER.debug("Entering chat room selection...");
		
		System.out.println("entering chat room selection...");
		
		arrChannels
                    = managerFactory.getChatManager()
                                  .getListChannel();

		
		if (arrChannels.isEmpty()) {
			this.addActionError("No channel yet, please submit a new one !");
			System.out.println("No channel yet...");
			LOGGER.debug("No channel yet...");
		} else {
			
			System.out.println(arrChannels);
		}
		
		return ActionSupport.SUCCESS;
		
	}
	
	/**
	 * Chat room with submitted id corresponding to a channel
	 * @return String action
	 */
	public String chatRoom() {
		
		LOGGER.debug("Entering chat room ...");
		
		return ActionSupport.SUCCESS;
	}
	
}