package me.daninator1.foodfiller;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodFillerListener implements Listener {
	
	public static FoodFiller plugin;
		
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		{
		    if (((event.getEntity() instanceof Player)) && plugin.playerList.contains(event.getEntity())){
		    {
		      event.setFoodLevel(20);
		      if(event.getEntity().getMaxFireTicks() > 1){
					event.getEntity().setFireTicks(0);
		      }
		    }
		  }
		}
}
}
