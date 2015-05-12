package main.java.net.huntersharpe.dev.harder_zombies;


import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by Hunter Sharpe on 5/10/15.
 */
public class ZombieListener implements Listener {

    public void onEntityDamage(EntityDamageByEntityEvent e){
        if(!e.getEntityType().equals(EntityType.ZOMBIE)) return;
        if(!e.getDamager().equals(EntityType.PLAYER)) return;

    }

}
