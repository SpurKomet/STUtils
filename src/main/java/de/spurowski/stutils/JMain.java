package de.spurowski.stutils;

import de.spurowski.stutils.commands.ResetCommand;
import de.spurowski.stutils.settings.settings;
import de.spurowski.stutils.util.Reset;
import org.bukkit.plugin.java.JavaPlugin;

public class JMain extends JavaPlugin {
    public static JMain instance;

    public void tOnLoad(){
        System.out.println("Load");
        String  test = settings.timer.look.INSTANCE.getColorOnPaused(); //exemple, how get settings

    }
    public void tOnEnable(){
        getCommand("reset").setExecutor(new ResetCommand());
        System.out.println("Startup");

    }
    public void tOnDisable(){
        System.out.println("Shutdown");
    }

    public static JMain getInstance() {
        return instance;
    }


}
