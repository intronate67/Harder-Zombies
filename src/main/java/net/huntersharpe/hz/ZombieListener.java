package main.java.net.huntersharpe.hz;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.util.Vector;

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

    public Map<String, Integer> zombieKillers = new HashMap<>();

    @EventHandler
    public void onEntityDamage(EntityDeathEvent e){

        //if(!e.getEntityType().equals(EntityType.ZOMBIE)) return;
        //below method is for above.
        if(!e.getEntityType().equals(EntityType.ZOMBIE)){
            Bukkit.broadcastMessage("Entity Was not zombie.");
            return;
        }
        //if(!e.getDamager().equals(EntityType.PLAYER)) return;
        //below method is for above
        if(e.getEntity().getKiller() instanceof Player){
            Player p = (Player) e.getEntity().getKiller();
            double y = p.getLocation().getY() + 100;
            Location loc = new Location(p.getWorld(),
                    p.getLocation().getX() + 35,
                    p.getWorld().getHighestBlockYAt((int) p.getLocation().getX(), (int) p.getLocation().getZ()),
                    p.getLocation().getZ()
            );
            if(!zombieKillers.containsKey(p.getName())){
                zombieKillers.put(p.getName(), 2);

                Zombie z1 = (Zombie)p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Zombie z2 = (Zombie)p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                //Testing
                p.sendMessage("First two Zombies Spawned");
                //Finished test message
                z1.setHealth(20);
                z2.setHealth(20);
                //Test message
                p.sendMessage("ZombieHealthSet");
                //Finished Test message
                z1.setTarget(p);
                z2.setTarget(p);
                //Testing
                p.sendMessage("Zombie targets set!");
                //finished testing

            }else if(zombieKillers.get(p.getName()) >= 10){
                return;
            }else {
                zombieKillers.put(p.getName(), zombieKillers.get(p.getName()) + 2);
                Zombie z1 = (Zombie) p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Zombie z2 = (Zombie) p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                //Testing
                p.sendMessage(zombieKillers.get(p.getName()) + " zombies have been spawned");
                //finished
                z1.setHealth(20);
                z2.setHealth(20);
                z1.setTarget(p);
                z2.setTarget(p);
            }
        }else{
            Bukkit.broadcastMessage("Killer was not player");
            return;
        }


    }


}
