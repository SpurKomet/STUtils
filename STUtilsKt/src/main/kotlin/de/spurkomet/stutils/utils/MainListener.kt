package de.spurowski.stutils

import de.spurkomet.stutils.colors
import net.axay.kspigot.chat.col
import net.axay.kspigot.event.listen
import net.kyori.adventure.text.Component
import org.bukkit.event.player.PlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

fun Listener(){
    listen<PlayerJoinEvent>(){
        it.joinMessage(Component.text("${colors["default"]}[${col("dark_red")}+${colors["default"]}]" +
                "${if(it.player.isOp) colors["admin"] else colors["player"]} ${it.player.name}"))
    }
    listen<PlayerQuitEvent>(){
        it.quitMessage(Component.text("${colors["default"]}[${col("dark_green")}-${colors["default"]}]" +
                "${if(it.player.isOp) colors["admin"] else colors["player"]} ${it.player.name}"))
    }
    listen<PlayerChatEvent> {
        it.format = "${if (it.player.isOp) colors["admin"] else colors["player"]}%1\$s${col("dark_gray")} | ${col("white")}%2\$s"
    }
}