package de.spurowski.stutils.settings

import kotlinx.serialization.json.Json
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.chat.col
import net.axay.kspigot.config.kSpigotConfig
import org.bukkit.World
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object settings {
    val dir = File("./plugins/SUtils/")
    val file = File(dir, "config.yml")
    var configuration = YamlConfiguration.loadConfiguration(file)

    object timer{
        var countdown = false
        var timer = false
        var isRun = false
        object time{
            var time = 0
            var sec = 0
            var min = 0
            var h = 0
        }
        object look{
            var colorOnRun = "gold"
            var colorOnPaused = "red"
        }
    }


    object position{
        var position = false
        var move = false
        //var positions = ArrayList<String>()
    }
    object backpack{
        var backpack = false
        var slots = 27 //vielfacher von 9
        var global = true
    }



    fun save(){
        // --- timer ---
        timer.countdown.setConf("settings.timer.countdown")
        timer.timer.setConf("settings.timer.timer")
        timer.isRun.setConf("settings.timer.isRun")
        timer.time.time.setConf("settings.timer.time.time")
        timer.time.sec.setConf("settings.timer.time.sec")
        timer.time.min.setConf("settings.timer.time.min")
        timer.time.h.setConf("settings.timer.time.h")
        timer.look.colorOnPaused.setConf("timer.look.colorOnPaused")
        timer.look.colorOnRun.setConf("timer.look.colorOnRun")
        // --- pos ---
        position.position.setConf("settings.position.position")
        position.move.setConf("settings.position.move")
        // --- backpack ---
        backpack.backpack.setConf("settings.backpack.backpack")
        backpack.slots.setConf("settings.backpack.slots")
        backpack.global.setConf("settings.backpack.global")
    }
    fun load(){
        // --- timer ---
        timer.countdown = getConf("settings.timer.countdown", timer.countdown)
        timer.timer = getConf("settings.timer.timer", timer.timer)
        timer.isRun = getConf("settings.timer.isRun", timer.isRun)
        timer.time.time = getConf("settings.timer.time.time", timer.time.time)
        timer.time.sec = getConf("settings.timer.time.sec", timer.time.sec)
        timer.time.min = getConf("settings.timer.time.min", timer.time.min)
        timer.time.h = getConf("settings.timer.time.h", timer.time.h)
        timer.look.colorOnPaused = getConf("settings.timer.look.colorOnPaused", timer.look.colorOnPaused)
        timer.look.colorOnRun = getConf("settings.timer.look.colorOnRun", timer.look.colorOnRun)

        // --- pos ---
        position.position = getConf("settings.position.position", position.position)
        position.move = getConf("settings.position.move", position.move)
        // --- backpack ---
        backpack.backpack = getConf("settings.backpack.backpack", backpack.backpack)
        backpack.slots = getConf("settings.backpack.slots", backpack.slots)
        backpack.global = getConf("settings.backpack.global", backpack.global)
    }
}