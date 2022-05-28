package de.spurowski.stutils;

import de.spurowski.stutils.settings.settings;
import org.bukkit.plugin.java.JavaPlugin;

public class JMain extends JavaPlugin {
    public static void tOnLoad(){
        System.out.println("Load");
        String  test = settings.timer.look.INSTANCE.getColorOnPaused(); //exemple, how get settings
    }
    public static void tOnEnable(){
        System.out.println("Startup");

    }
    public static void tOnDisable(){
        System.out.println("Shutdown");
    }
}
