package main.java.net.huntersharpe.hz;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Hunter Sharpe on 5/12/15.
 */
public class DeathListener implements Listener{

    private static ZombieListener zombie = ZombieListener.getInstance();

    public void onPlayerDeath(PlayerDeathEvent e){
        Player p = (Player) e.getEntity();
        if(!zombie.zombieKillers.containsValue(p.getName())) return;
        else{
            zombie.zombieKillers.replace(p.getName(),
                    zombie.zombieKillers.get(p.getName()),
                    0
            );
            zombie.zombieKillers.remove(p.getName());
        }
    }

}
