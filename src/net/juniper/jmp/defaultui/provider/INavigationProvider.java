package net.juniper.jmp.defaultui.provider;
import java.util.List;

import net.juniper.jmp.defaultui.home.NavType;
/**
 * A tasks provider for main ui
 * @author juntaod
 *
 */
public interface INavigationProvider {
	public List<NavType> getNavTypes();
}
