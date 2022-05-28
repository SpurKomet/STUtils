package de.spurowski.stutils.utils

import de.spurowski.stutils.apis.printUsage
import de.spurowski.stutils.settings.settings
import net.axay.kspigot.chat.col
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.literal
import net.axay.kspigot.commands.runs
import net.axay.kspigot.extensions.broadcast


class Commands{
    val test = command("test"){
        runs {
            broadcast("test")
            this.player.sendMessage("${col("red")}test")
        }
    }
    val timerCommand = command("timer"){
        runs{
            printUsage("timer", this.player)
        }
        literal("resume"){
            runs{
                if (!settings.timer.timer){
                    settings.timer.timer = true
                    runTimer()
                }
                settings.timer.isRun = true
            }
        }
        literal("pause"){
            runs{
                settings.timer.isRun = false
            }
        }
        literal("reset"){
            runs{
                settings.timer.isRun = false
                settings.timer.time.time = 0
                calcToRead()
            }
        }
        literal("settings"){
            runs{

            }
        }
    }
}





