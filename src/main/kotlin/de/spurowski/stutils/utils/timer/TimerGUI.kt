package de.spurowski.stutils.utils.timer

import de.spurowski.stutils.apis.getPrefix
import de.spurowski.stutils.colors
import net.axay.kspigot.chat.col
import net.axay.kspigot.gui.GUIType
import net.axay.kspigot.gui.Slots
import net.axay.kspigot.gui.kSpigotGUI
import net.kyori.adventure.text.Component

import de.spurowski.stutils.settings.settings.timer.time.h
import de.spurowski.stutils.settings.settings.timer.time.min
import de.spurowski.stutils.settings.settings.timer.time.sec
import de.spurowski.stutils.settings.settings.timer.timer
import de.spurowski.stutils.settings.settings.timer.time.time
import de.spurowski.stutils.settings.settings.timer.countdown
import de.spurowski.stutils.utils.calcToSec
import de.spurowski.stutils.utils.runTimer

class TimerGUI {
    private val timerColor = col("green")
    val gui = kSpigotGUI(GUIType.FIVE_BY_NINE) {
        title = Component.text("Timer Settings")
        defaultPage = 0

        page(0) {
            this.button(Slots.RowFourSlotOne, TimerDisplayItems.timer()) {
                if (timer) {
                    timer = false
                    it.player.sendMessage(
                        "${getPrefix("timer")}Der$timerColor Timer " +
                                "${colors.get("default")}wurde " +
                                "${colors.get("disable")}deaktiviert${colors.get("default")}."
                    )
                } else {
                    timer = true
                    runTimer()
                    it.player.sendMessage(
                        "${getPrefix("timer")}Der$timerColor Timer " +
                                "${colors.get("default")}wurde " +
                                "${colors.get("enable")}aktiviert${colors.get("default")}."
                    )
                }
                it.bukkitEvent.currentItem = TimerDisplayItems.timer()
            }

            //--------------- timer.sec ----------------------
            this.button(Slots.RowFourSlotFour, TimerDisplayItems.sec()) {
                if (it.bukkitEvent.click.isLeftClick) {
                    if(sec < 59) {
                        sec++
                        it.player.sendMessage("${getPrefix("timer")}${timerColor} Sekunden ${colors.get("default")}wurde auf ${colors.get("value")}$sec ${colors.get("default")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Sekunden ${colors.get("default")}ist bereits auf: ${colors.get("value")}$sec")
                    }
                }
                if (it.bukkitEvent.click.isRightClick) {
                    if(sec > 0) {
                        sec--
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Sekunden ${colors.get("default")}wurde auf ${colors.get("value")}$sec ${colors.get("default")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Sekunden ${colors.get("default")}ist bereits auf: ${colors.get("value")}$sec")
                    }
                }
                calcToSec()
                it.bukkitEvent.currentItem = TimerDisplayItems.sec()
            }

            //--------------- timer.min ----------------------
            this.button(Slots.RowFourSlotFive, TimerDisplayItems.min()) {
                if (it.bukkitEvent.click.isLeftClick) {
                    if(min < 59) {
                        min++
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Minuten ${colors.get("default")}wurde auf ${colors.get("value")}$min ${colors.get("default")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Minuten ${colors.get("default")}ist bereits auf: ${colors.get("value")}$min")
                    }
                }
                if (it.bukkitEvent.click.isRightClick) {
                    if(min > 0) {
                        min--
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Minuten ${colors.get("default")}wurde auf ${colors.get("value")}$min ${colors.get("default")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Minuten ${colors.get("default")}ist bereits auf: ${colors.get("value")}$min")
                    }
                }
                calcToSec()
                it.bukkitEvent.currentItem = TimerDisplayItems.min()
            }

            //--------------- timer.h ----------------------
            this.button(Slots.RowFourSlotSix, TimerDisplayItems.h()) {
                if (it.bukkitEvent.click.isLeftClick) {
                    if(h < 24) {
                        h++
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Stunden ${colors.get("default")}wurde auf ${colors.get("value")}$h ${colors.get("default")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Stunden ${colors.get("default")}ist bereits auf: ${colors.get("value")}$h")
                    }
                }
                if (it.bukkitEvent.click.isRightClick) {
                    if(h > 0) {
                        h--
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Stunden ${colors.get("default")}wurde auf ${colors.get("value")}$h ${colors.get("default")}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Stunden ${colors.get("default")}ist bereits auf: ${colors.get("value")}$h")
                    }
                }
                calcToSec()
                it.bukkitEvent.currentItem = TimerDisplayItems.h()
            }

            //--------------- timer.countdown ----------------------
            this.button(Slots.RowFourSlotNine, TimerDisplayItems.countdown()) {
                if(countdown) {
                    countdown = false
                    it.player.sendMessage("${getPrefix("timer")}${timerColor}Countdown ${colors.get("default")}wurde auf ${colors.get("disable")}$countdown ${colors.get("default")}gesetzt.")
                }
                else{
                    if (time != 0){
                        countdown = true
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Countdown ${colors.get("default")}wurde auf ${colors.get("enable")}$countdown ${colors.get("default")}gesetzt.")
                    }else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Countdown ${colors.get("error")}wurde beibehalten [${colors.get("enable")}$countdown${colors.get("error")}]. (null)")
                    }
                }
                it.bukkitEvent.currentItem = TimerDisplayItems.countdown()
            }
            this.placeholder(Slots.RowOne, TimerDisplayItems.fill)
        }
    }
}
