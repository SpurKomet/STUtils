package de.spurkomet.stutils.utils

import de.spurkomet.stutils.apis.getPrefix
import de.spurkomet.stutils.apis.printUsage
import de.spurkomet.stutils.colors
import de.spurkomet.stutils.settings.save
import de.spurkomet.stutils.settings.settings.timer.isRun
import de.spurkomet.stutils.settings.settings.timer.time.time
import de.spurkomet.stutils.settings.settings.timer.timer
import de.spurowski.stutils.utils.calcToRead
import de.spurowski.stutils.utils.runTimer
import de.spurkomet.stutils.utils.timer.TimerGUI
import de.spurkomet.stutils.utils.worldsettings.WorldSettingsGUI
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.literal
import net.axay.kspigot.commands.runs
import net.axay.kspigot.gui.openGUI


class Commands{
    val test = command("test"){
        runs {
            save()
        }
    }
    val timerCommand = command("timer"){
        runs{
            printUsage("timer", this.player)
        }
        literal("resume"){
            runs{
                if (!timer){
                    timer = true
                    runTimer()
                }
                isRun = true
            }
        }
        literal("pause"){
            runs{
                isRun = false
            }
        }
        literal("reset"){
            runs{
                isRun = false
                time = 0
                calcToRead()
            }
        }
        literal("settings"){
            runs{
                if (this.player.isOp){
                    isRun = false
                    this.player.openGUI(TimerGUI().gui)
                }else{
                    this.player.sendMessage("${getPrefix("plugin")}${colors.get("error")}Du brauchst ${colors.get("admin")}op${colors.get("error")}, um diesen command auszuführen")
                }
            }
        }
    }
    val worldSettings = command("worldsettings"){
        runs {
            if (this.player.isOp){
                isRun = false
                this.player.openGUI(WorldSettingsGUI().settingsGUI)
            }else{
                this.player.sendMessage("${getPrefix("plugin")}${colors.get("error")}Du brauchst ${colors.get("admin")}op${colors.get("error")}, um diesen command auszuführen")
            }
        }
    }
}





