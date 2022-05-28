package de.spurowski.stutils.apis

import de.spurowski.stutils.*
import net.axay.kspigot.chat.col
import net.md_5.bungee.api.ChatColor
import org.bukkit.entity.Player

private data class usage(val prefix: String , val usage: String)
private val usages = HashMap<String, usage>()
fun setUsage(name: String,
             massage: String,
             prefixName: String = "server",
             usageColor: ChatColor =
                 if(colors.get("usage") != null) colors.get("usage")!!
                 else if(colors.get("default") != null) colors.get("default")!!
                 else col("white"))
{
    if (usages.get(name) == null){
        usages.put(name, usage(getPrefix(prefixName), "$usageColor$massage"))
    }else{
        var count = 1
        while (usages.get("${name}_$count") != null){
            count++
        }
        usages.put(name, usage(getPrefix(prefixName), "$usageColor$massage"))
        println("Info: usage '${name}_$count' wurde erstellt!")
    }
}
fun getUsage(name: String, prefix: Boolean = true): String {
    if(usages.get(name) != null){
        if (prefix){
            return "${usages.get(name)!!.prefix} ${usages.get(name)!!.usage}"
        }else{
            return usages.get(name)!!.usage
        }
    } else return "${getPrefix("default")}${colors.get("error")}usage.$name"
}
fun printUsage(name: String, player: Player){
    player.sendMessage(getUsage(name))
}