package main.java.net.huntersharpe.hz;


import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hunter Sharpe on 5/10/15.
 */
public class ZombieListener implements Listener {

    private static ZombieListener instance;

    public static ZombieListener getInstance(){
        return instance;
    }

    public Map<String, Integer> zombieKillers = new HashMap<String, Integer>();

    public void onEntityDamage(EntityDamageByEntityEvent e){

        if(!e.getEntityType().equals(EntityType.ZOMBIE)) return;
        if(!e.getDamager().equals(EntityType.PLAYER)) return;

        Player p = (Player) e.getDamager();
        Location loc = new Location(p.getWorld(),
                p.getLocation().getX() + 35,
                p.getLocation().getY() + 100,
                p.getLocation().getZ()
        );

        if(!zombieKillers.containsKey(p.getName())){
            zombieKillers.put(p.getName(), 2);

            Zombie z1 = (Zombie)p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            Zombie z2 = (Zombie)p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            z1.setHealth(60);
            z2.setHealth(60);
            z1.setTarget(p);
            z2.setTarget(p);
        }else if(zombieKillers.get(p.getName()) >= 10){
            return;
        }else{
            zombieKillers.put(p.getName(), zombieKillers.get(p.getName()) + 2);
            Zombie z1 = (Zombie)p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            Zombie z2 = (Zombie)p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            z1.setHealth(60);
            z2.setHealth(60);
            z1.setTarget(p);
            z2.setTarget(p);
        }

    }


}
