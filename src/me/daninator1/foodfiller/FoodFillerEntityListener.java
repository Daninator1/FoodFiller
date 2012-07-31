package me.daninator1.foodfiller;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodFillerEntityListener extends EntityListener {
	
	public static FoodFiller plugin;
	
	public FoodFillerEntityListener(FoodFiller FoodFiller) {
		plugin = FoodFiller;
	}
	
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
