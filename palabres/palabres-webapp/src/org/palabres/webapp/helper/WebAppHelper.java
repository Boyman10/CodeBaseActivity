package org.palabres.webapp.helper;

import org.example.palabres.business.contract.ManagerFactory;

/**
 * Classe de helper temporaire pour la webapp...
 */
@Deprecated
public abstract class WebAppHelper {

    private static ManagerFactory managerFactory;

    public static ManagerFactory getManagerFactory() {
        return managerFactory;
    }
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}