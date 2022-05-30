package de.spurowski.stutils.utils.worldsettings

import de.spurowski.stutils.apis.getPrefix
import de.spurowski.stutils.colors
import de.spurowski.stutils.settings.settings.World.difficulty.hardcore
import de.spurowski.stutils.settings.settings.World.difficulty.uHardcore
import de.spurowski.stutils.settings.settings.World.difficulty.uuHardcore
import org.bukkit.entity.Player

object difficulty{
    fun toHC(player: Player){
        if (!uuHardcore && !uHardcore){
            hardcore = !hardcore
        }else{
            player.sendMessage("${getPrefix("world")}${colors["value"]}${if (uHardcore) "Ultra Hardcore" else "Ultra Ultra Hardcore"}${colors["error"]} ist bereits Aktiv!")
        }
    }
    fun toUHC(player: Player){
        if (!uuHardcore && !hardcore){
            uHardcore = !uHardcore
        }else{
            player.sendMessage("${getPrefix("world")}${colors["value"]}${if (hardcore) "Hardcore" else "Ultra Ultra Hardcore"}${colors["error"]} ist bereits Aktiv!")
        }
    }
    fun toUUHC(player: Player){
        if (!hardcore && !uHardcore){
            uuHardcore = !uuHardcore
        }else{
            player.sendMessage("${getPrefix("world")}${colors["value"]}${if (uHardcore) "Ultra Hardcore" else "Hardcore"}${colors["error"]} ist bereits Aktiv!")
        }
    }
}