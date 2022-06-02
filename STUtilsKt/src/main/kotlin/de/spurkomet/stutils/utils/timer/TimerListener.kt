package de.spurkomet.stutils.utils.timer

import de.spurkomet.stutils.settings.settings.timer.isRun
import de.spurkomet.stutils.settings.settings.timer.timer
import net.axay.kspigot.event.listen
import net.axay.kspigot.sound.sound
import org.bukkit.Sound
import org.bukkit.entity.EntityType
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityExplodeEvent
import org.bukkit.event.entity.FoodLevelChangeEvent

fun timerListener(){
    listen<EntityDamageEvent> {
        if (!isRun && timer && it.entity.type == EntityType.PLAYER) it.isCancelled = true
    }
    listen<FoodLevelChangeEvent> {
        if (!isRun && timer && it.entity.type == EntityType.PLAYER) it.isCancelled = true
    }
    listen<BlockBreakEvent> {
        if (!isRun && timer) it.isCancelled = true
    }
    listen<EntityExplodeEvent> {
        if (!isRun && timer) it.isCancelled = true; it.location.sound(Sound.ENTITY_GENERIC_EXPLODE)
    }
}