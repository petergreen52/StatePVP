package fire.StatePVP.main;

import org.bukkit.event.Listener;

public class Listeners implements Listener {
  
  @EventHandler
  public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
    Player target = Bukkit.getServer().getEntity()
    if () {
      e.setCancelled(true);
    }
  }
}
