package de.spurowski.stutils

import net.axay.kspigot.event.listen
import net.kyori.adventure.text.Component
import org.bukkit.event.player.PlayerJoinEvent

fun Listener(){
    listen<PlayerJoinEvent>(){
        it.joinMessage(Component.text(""))
    }
}