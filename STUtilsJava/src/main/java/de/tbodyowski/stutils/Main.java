package de.tbodyowski.stutils;

import de.tbodyowski.stutils.commands.ResetCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onLoad() {
    }

    @Override
    public void onDisable() {
        getCommand("reset").setExecutor(new ResetCommand());
        System.out.println("Startup");
    }

    @Override
    public void onEnable() {

    }


    public static Main getInstance() {
        return instance;
    }


}
