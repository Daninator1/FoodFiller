package me.daninator1.foodfiller;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FoodFiller extends JavaPlugin{
	public static FoodFiller plugin;
	public final ArrayList<Player> playerList = new ArrayList<Player>();
	FoodFillerEntityListener entityListener = new FoodFillerEntityListener(this);

	@Override
	public void onDisable() {
		System.out.println("FoodFiller successfully disabled!");
		
	}

	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
        
        FoodFillerEntityListener entityListener = new FoodFillerEntityListener(this);
        pm.registerEvent(Event.Type.FOOD_LEVEL_CHANGE, entityListener, Event.Priority.Normal, this);
		System.out.println("FoodFiller successfully enabled!");
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		boolean succeed = true;
		
		if (sender instanceof Player) {
		    Player player = (Player) sender;
		    
		    
		    if (cmd.getName().equalsIgnoreCase("food")) 
		    	if (player.hasPermission("foodfiller.food")){
		    		
		    		player.setFoodLevel(20);
		    		System.out.println("[FoodFiller] " + player.getName() + " filled his Food Level!");
		    		
		        succeed = true;
		         {
		    	player.sendMessage(ChatColor.AQUA + "[FoodFiller] Your Food Level is now full!");
		    	 }
		        }
		    else player.sendMessage(ChatColor.RED + "[FoodFiller] You don't have permission to do that.");
		    
		    
		    
		    
		    if (cmd.getName().equalsIgnoreCase("ffreeze"))
		    	if (player.hasPermission("foodfiller.freeze")){
		    		
		    		playerList.add((Player)sender);
		    		System.out.println("[FoodFiller] " + player.getName() + " froze his Food Level!");
				
				succeed = true;
				 {
				player.sendMessage(ChatColor.AQUA + "[FoodFiller] " + ChatColor.AQUA + "Your Food Level is now frozen!");
				 }
		    	}
	    	else player.sendMessage(ChatColor.RED + "[FoodFiller] You don't have permission to do that.");
		    
		    
		    
		    
		    if (cmd.getName().equalsIgnoreCase("funfreeze"))
		    	if (player.hasPermission("foodfiller.freeze")){
		    		
			        playerList.remove((Player)sender);
			        System.out.println("[FoodFiller] " + player.getName() + " unfroze his Food Level!");
			  
			  succeed = true;
				 {
				player.sendMessage(ChatColor.AQUA + "[FoodFiller] " + ChatColor.AQUA + "Your Food Level is not frozen anymore!");
				 }
		    	}
	    	else player.sendMessage(ChatColor.RED + "[FoodFiller] You don't have permission to do that.");
	}
		return succeed;

}
}
