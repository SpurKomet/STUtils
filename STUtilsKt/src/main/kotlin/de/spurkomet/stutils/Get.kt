package de.spurkomet.stutils

import de.spurkomet.stutils.apis.addPrefix
import de.spurkomet.stutils.apis.setUsage
import net.axay.kspigot.chat.col
import net.md_5.bungee.api.ChatColor

val colors = HashMap<String, ChatColor>()
fun setGets(){
    //Colors
    colors.put("default", col("white"))
    colors.put("error", col("red"))

    colors.put("arg", col("blue"))
    colors.put("command", col("gray"))

    colors.put("admin", col("dark_aqua"))
    colors.put("player", col("white"))

    colors.put("disable", col("dark_red"))
    colors.put("enable", col("dark_green"))
    colors.put("value", col("yellow"))

    //Prefixes
    "STUtils".addPrefix("plugin", col("aqua"))
    "Timer".addPrefix(color = col("green"))
    "World".addPrefix()

    //Usages
    setUsage("timer", "Verwendung: ${colors.get("command")}/timer ${colors.get("arg")}resume ${colors.get("default")}| ${colors.get("arg")}pause ${colors.get("default")}| ${colors.get("arg")}reset ${colors.get("default")}| ${colors.get("arg")}settings", "timer")
}




