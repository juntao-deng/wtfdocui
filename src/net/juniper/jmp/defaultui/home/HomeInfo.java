package net.juniper.jmp.defaultui.home;
import java.util.List;

import net.juniper.jmp.defaultui.clientinfo.ClientSessionBean;

public class HomeInfo {
	private List<NavType> navList;
	private ClientSessionBean sessionBean;
	public List<NavType> getNavList() {
		return navList;
	}
	public void setNavList(List<NavType> navList) {
		this.navList = navList;
	}
	public ClientSessionBean getSessionBean() {
		return sessionBean;
	}
	public void setSessionBean(ClientSessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
}
