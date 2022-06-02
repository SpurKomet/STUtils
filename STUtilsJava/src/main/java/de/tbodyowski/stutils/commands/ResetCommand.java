package de.tbodyowski.stutils.commands;

import de.tbodyowski.stutils.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class ResetCommand implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String label,  String[] args) {
        Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("§9Reset von §8" + sender + " ausgeführt"));
        Main.getInstance().getConfig().set("isReset", true);
        Main.getInstance().saveConfig();
        Bukkit.spigot().restart();
        return false;
    }
}
