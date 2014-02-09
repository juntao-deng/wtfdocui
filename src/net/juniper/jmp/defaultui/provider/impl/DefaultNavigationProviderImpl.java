package net.juniper.jmp.defaultui.provider.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import net.juniper.jmp.defaultui.home.NavGroupMO;
import net.juniper.jmp.defaultui.home.NavItemMO;
import net.juniper.jmp.defaultui.home.NavType;
import net.juniper.jmp.defaultui.provider.INavigationProvider;
import net.juniper.jmp.persist.IJmpPersistenceManager;
import net.juniper.jmp.wtf.ctx.Sort;
import net.juniper.jmp.wtf.ctx.Sort.Order;
import net.juniper.jmp.wtf.utils.IMoEntityConvertor;
import net.juniper.jmp.wtf.utils.MoEntityConvertor;

public class DefaultNavigationProviderImpl implements INavigationProvider {
	@Inject
	private IJmpPersistenceManager em;
	private IMoEntityConvertor<NavItemMO, NavItemEntity> itemConvertor;
	private IMoEntityConvertor<NavGroupMO, NavGroupEntity> groupConvertor;
	
    public List<NavGroupEntity> getNavGroups(){
    	Order order = new Order("id");
    	Sort sort = new Sort(order);
    	return (List<NavGroupEntity>) em.findAll(NavGroupEntity.class, sort);
    }
    
    public List<NavItemEntity> getNavItems() {
    	Order order = new Order("id");
    	Sort sort = new Sort(order);
    	return (List<NavItemEntity>) em.findAll(NavItemEntity.class, sort);
    }

	@Override
	public List<NavType> getNavTypes() {
		List<NavType> allList = new ArrayList<NavType>();
		List<NavGroupEntity> groupList = getNavGroups();
		List<NavItemEntity> itemList = getNavItems();
		List<NavGroupMO> groupMoList = convertGroupEntitys(groupList);
		List<NavItemMO> itemMoList = convertItemEntitys(itemList);
		allList.addAll(groupMoList);
		allList.addAll(itemMoList);
		return allList;
	}
	
	private List<NavGroupMO> convertGroupEntitys(List<NavGroupEntity> groups){
		return getGroupConvertor().convertFromEntity2Mo(groups, NavGroupMO.class);
	}
	
	private List<NavItemMO> convertItemEntitys(List<NavItemEntity> items){
		return getMoEntityConvertor().convertFromEntity2Mo(items, NavItemMO.class);
	}
	
	private IMoEntityConvertor<NavItemMO, NavItemEntity> getMoEntityConvertor(){
		if(itemConvertor == null){
			itemConvertor = new MoEntityConvertor<NavItemMO, NavItemEntity>(){
				@Override
				public List<NavItemEntity> convertFromMo2Entity(List<NavItemMO> moList, Class<NavItemEntity> clazz) {
					List<NavItemEntity> items = super.convertFromMo2Entity(moList, clazz);
					//further process
					return items;
				}
				@Override
				public List<NavItemMO> convertFromEntity2Mo(List<NavItemEntity> entityList, Class<NavItemMO> clazz) {
					List<NavItemMO> items = super.convertFromEntity2Mo(entityList, clazz);
					//further process
					return items;
				}
			};
		}
		return itemConvertor;
	}
	
	private IMoEntityConvertor<NavGroupMO, NavGroupEntity> getGroupConvertor(){
		if(groupConvertor == null){
			groupConvertor = new MoEntityConvertor<NavGroupMO, NavGroupEntity>(){
				@Override
				public List<NavGroupEntity> convertFromMo2Entity(List<NavGroupMO> moList, Class<NavGroupEntity> clazz) {
					List<NavGroupEntity> items = super.convertFromMo2Entity(moList, clazz);
					//further process
					return items;
				}
				@Override
				public List<NavGroupMO> convertFromEntity2Mo(List<NavGroupEntity> entityList, Class<NavGroupMO> clazz) {
					List<NavGroupMO> items = super.convertFromEntity2Mo(entityList, clazz);
					//further process
					return items;
				}
			};
		}
		return groupConvertor;
	}
}
