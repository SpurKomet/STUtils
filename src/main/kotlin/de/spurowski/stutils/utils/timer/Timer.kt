package de.spurowski.stutils.utils

import de.spurowski.stutils.colors
import de.spurowski.stutils.settings.settings
import de.spurowski.stutils.settings.settings.timer.countdown
import de.spurowski.stutils.settings.settings.timer.isRun
import de.spurowski.stutils.settings.settings.timer.time.h
import de.spurowski.stutils.settings.settings.timer.time.min
import de.spurowski.stutils.settings.settings.timer.time.sec
import de.spurowski.stutils.settings.settings.timer.time.time
import de.spurowski.stutils.settings.settings.timer.timer
import net.axay.kspigot.chat.col
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.extensions.bukkit.actionBar
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.runnables.task
import org.bukkit.GameMode


fun runTimer(){
    task(
        true,
        0,
        20
    )
    {
        if (!timer){
            it.cancel()
        }
        if (isRun){
            if (countdown){
                time--
                if (time == 0){
                    broadcast("${colors.get("error")}GameOver - Zeit abgelaufen")
                    countdown = false
                    isRun = false
                    onlinePlayers.forEach { it.gameMode = GameMode.SPECTATOR }
                }
            }else{
                time++
            }
            calcToRead()
        }
        barTimer()
    }
}

fun barTimer(){
    if (!isRun){
        onlinePlayers.forEach {
            it.actionBar(
                col(settings.timer.look.colorOnPaused).toString() +
                    "${if (h < 10)"0$h" else h}:" +
                    "${if (min < 10)"0$min" else min}:" +
                    "${if (sec < 10)"0$sec" else sec}" +
                    " (frozed)")
        }
    }
    else{
        onlinePlayers.forEach {
            it.actionBar(
                col(settings.timer.look.colorOnRun).toString() +
                    "${if (h < 10)"0$h" else h}:" +
                    "${if (min < 10)"0$min" else min}:" +
                    "${if (sec < 10)"0$sec" else sec}")
        }
    }
    if (!timer){
        onlinePlayers.forEach{it.actionBar("")}
    }
}
fun calcToSec(){
    time = ((h*3600)+(min*60)+sec)
}
fun calcToRead(){
    sec = (time-(time/60)*60)
    min = (time/60-(time/3600)*60)
    h = time/3600
}

