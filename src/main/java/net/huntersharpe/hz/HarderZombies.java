package main.java.net.huntersharpe.hz;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Hunter Sharpe on 5/10/15.
 */
public class HarderZombies extends JavaPlugin {

    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ZombieListener(), this);
        pm.registerEvents(new DeathListener(), this);
    }

    public void onDisable() {

    }
}
