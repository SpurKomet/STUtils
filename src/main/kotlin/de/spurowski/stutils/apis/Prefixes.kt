package de.spurowski.stutils.apis

import de.spurowski.stutils.colors
import net.axay.kspigot.chat.col
import net.md_5.bungee.api.ChatColor

private object prefix{
    val prefixDefault = "["
    val prefixDefaultColor = col("gray")
    val prefixTexts = HashMap<String, String>()
    val prefixTextColor = col("blue")
    val postfixDefault = "]"
    val postfixDefaultColor = col("gray")
}
fun String.addPrefix(name: String = this.lowercase(),
                     color: ChatColor = prefix.prefixTextColor,
                     prefixColor: ChatColor = prefix.prefixDefaultColor,
                     prefixChar: String = prefix.prefixDefault,
                     postfixColor: ChatColor = prefix.postfixDefaultColor,
                     postfixChar: String = prefix.postfixDefault){
    if (prefix.prefixTexts.get(name) == null){
        prefix.prefixTexts.put(name, "$prefixColor$prefixChar$color$this$postfixColor$postfixChar${colors.get("default")} ")
    }else{
        var count = 1
        while (prefix.prefixTexts.get("${name}_$count") != null){
            count++
        }
        prefix.prefixTexts.put("${name}_$count", "$prefixColor$prefixChar$color$this$postfixColor$postfixChar${colors.get("default")} ")
        println("Info: prefix '${name}_$count' wurde erstellt!")
    }


}
fun getPrefix(name: String): String =
    if(prefix.prefixTexts.get(name) != null) prefix.prefixTexts.get(name)!!
    else "${prefix.prefixDefault}${colors.get("error")}prefix.$name${prefix.postfixDefault} "



