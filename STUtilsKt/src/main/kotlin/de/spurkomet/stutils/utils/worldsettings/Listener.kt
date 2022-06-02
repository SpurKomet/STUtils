package de.spurkomet.stutils.utils.worldsettings

import de.spurkomet.stutils.apis.getPrefix
import de.spurkomet.stutils.settings.settings.World.difficulty.hardcore
import de.spurkomet.stutils.settings.settings.World.difficulty.uHardcore
import de.spurkomet.stutils.settings.settings.World.difficulty.uuHardcore
import de.spurkomet.stutils.settings.settings.timer.challenges.bob
import de.spurkomet.stutils.settings.settings.timer.challenges.enderDragon
import de.spurkomet.stutils.settings.settings.timer.challenges.wither
import de.spurkomet.stutils.settings.settings.timer.isRun
import de.spurkomet.stutils.settings.settings.timer.timer
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta


import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Hanging
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.EntityRegainHealthEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.potion.PotionType

fun worldListener(){
    listen<PlayerDeathEvent> {PlayerDeathEvent ->
        if (hardcore || uHardcore || uuHardcore){
            if (!isRun) isRun = false
            onlinePlayers.forEach { it.gameMode = GameMode.SPECTATOR; it.sendMessage("${getPrefix("world")}${PlayerDeathEvent.player.name} ist gestorben! - Game Over")}
        }
    }
    listen<EntityDeathEvent> {
        if (timer){
            if (it.entity.type == EntityType.ENDER_DRAGON && enderDragon){
                isRun = false
                onlinePlayers.forEach { it.sendMessage("${getPrefix("timer")}Der Enderdrache wurde erfolgreich besiegt!")}
            }
            if (it.entity.type == EntityType.ELDER_GUARDIAN && bob){
                isRun = false
                onlinePlayers.forEach { it.sendMessage("${getPrefix("timer")}Bob wurde erfolgreich besiegt!")}
            }
            if (it.entity.type == EntityType.WITHER && wither){
                isRun = false
                onlinePlayers.forEach { it.sendMessage("${getPrefix("timer")}Der Wither wurde erfolgreich besiegt!")}
            }
        }
    }
    listen<EntityRegainHealthEvent> {
        if (uuHardcore && it.entity.type == EntityType.PLAYER){
            it.isCancelled = true
        }
    }
    listen<PlayerInteractEvent> {
        if (uuHardcore){
            broadcast("ttt")
            it.isCancelled = when (it.player.inventory.itemInMainHand){
                itemStack(Material.GOLDEN_APPLE){} -> true
                itemStack(Material.ENCHANTED_GOLDEN_APPLE){} -> true
                itemStack(Material.POTION){meta{ PotionType.INSTANT_HEAL }} -> true
                itemStack(Material.POTION){meta{ PotionType.REGEN }} -> true
                else -> false
            }
        }
    }
}