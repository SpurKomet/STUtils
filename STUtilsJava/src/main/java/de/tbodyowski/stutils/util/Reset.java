package de.tbodyowski.stutils.util;

import de.tbodyowski.stutils.Main;
//import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;

public class Reset {
    public void doReset(){
        if (!Main.getInstance().getConfig().contains("isReset")){
            Main.getInstance().getConfig().set("isReset", false);
            Main.getInstance().saveConfig();
            return;
        }
        if (Main.getInstance().getConfig().getBoolean("isReset")){
            //try {
                File world = new File(Bukkit.getWorldContainer(), "world");
                File nether = new File(Bukkit.getWorldContainer(), "world_nether");
                File end = new File(Bukkit.getWorldContainer(), "world_the_end");
                //delete the Directories
                //FileUtils.deleteDirectory(world);
                //FileUtils.deleteDirectory(nether);
                //FileUtils.deleteDirectory(end);
                //create the new worlds
                world.mkdirs();
                nether.mkdirs();
                end.mkdirs();

                //world
                new File(world, "data").mkdirs();
                new File(world, "playerdata").mkdirs();
                new File(world, "datapacks").mkdirs();
                new File(world, "poi").mkdirs();
                new File(world, "region").mkdirs();

                //nether
                new File(nether, "data").mkdirs();
                new File(nether, "playerdata").mkdirs();
                new File(nether, "datapacks").mkdirs();
                new File(nether, "poi").mkdirs();
                new File(nether, "region").mkdirs();

                //end
                new File(end, "data").mkdirs();
                new File(end, "playerdata").mkdirs();
                new File(end, "datapacks").mkdirs();
                new File(end, "poi").mkdirs();
                new File(end, "region").mkdirs();
            /*} catch (IOException e) {
                throw new RuntimeException(e);
            }*/
            Main.getInstance().getConfig().set("isReset", false);
            Main.getInstance().saveConfig();
        }
    }
}
