package net.juniper.jmp.mainui.restful.impl;
import java.util.Calendar;
import java.util.List;

import net.juniper.jmp.core.locator.ServiceLocator;
import net.juniper.jmp.mainui.home.HomeInfo;
import net.juniper.jmp.mainui.home.NavType;
import net.juniper.jmp.mainui.restful.HomeRestService;
import net.juniper.jmp.mainui.services.NavTypeService;
import net.juniper.jmp.mainui.sys.SessionBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeRestServiceImpl implements HomeRestService{
   private Logger logger = LoggerFactory.getLogger(HomeRestServiceImpl.class);
   @Override
   public HomeInfo getHomeInfo() {
	   HomeInfo homeInfo = new HomeInfo();
	   try{
		   List<NavType> groupList = ServiceLocator.getService(NavTypeService.class).getNavList();
		   homeInfo.setNavList(groupList);
		   
		   
		   SessionBean sb = new SessionBean();
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
