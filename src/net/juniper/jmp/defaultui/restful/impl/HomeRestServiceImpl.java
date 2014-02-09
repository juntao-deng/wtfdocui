package net.juniper.jmp.defaultui.restful.impl;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import net.juniper.jmp.defaultui.clientinfo.ClientSessionBean;
import net.juniper.jmp.defaultui.home.HomeInfo;
import net.juniper.jmp.defaultui.home.NavType;
import net.juniper.jmp.defaultui.provider.INavigationProvider;
import net.juniper.jmp.defaultui.restful.HomeRestService;

import org.apache.log4j.Logger;

public class HomeRestServiceImpl implements HomeRestService{
	@Inject
	private Logger logger;
	@Inject
	private INavigationProvider navProvider;
	@Override
	public HomeInfo getHomeInfo() {
	   HomeInfo homeInfo = new HomeInfo();
	   try{
		   List<NavType> groupList = navProvider.getNavTypes();
		   homeInfo.setNavList(groupList);
		   
		   
		   ClientSessionBean sb = new ClientSessionBean();
		   sb.setLoginDate(Calendar.getInstance().getTime());
		   sb.setUserCode("super");
		   sb.setUserId("super");
		   homeInfo.setSessionBean(sb);
		   return homeInfo;
	   }
	   catch(Throwable e){
		   logger.error(e.getMessage(), e);
		   return homeInfo;
	   }
	   
   } 
} 
