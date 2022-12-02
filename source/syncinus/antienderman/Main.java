package syncinus.antienderman;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("deprecation")
public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		Bukkit.getLogger().info("Loading...");
		
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		Bukkit.getLogger().info("Unloading...");
	}
	
	@EventHandler
	public void onEntityChangeBlock(EntityChangeBlockEvent event) {
		boolean conditions = event.getEntityType() == EntityType.ENDERMAN ||
							 event.getEntityType() == EntityType.ENDER_DRAGON;
		
		if (conditions) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent event) {
		boolean conditions = event.getEntityType() == EntityType.ENDERMAN;
		
		if (conditions) {
			Enderman enderman = (Enderman) event.getEntity();
			enderman.setCarriedMaterial(new MaterialData(Material.AIR));
		}	
	}
}
