package de.spurowski.stutils.utils.timer

import de.spurowski.stutils.apis.getPrefix
import de.spurowski.stutils.colors
import de.spurowski.stutils.settings.settings
import de.spurowski.stutils.settings.settings.timer.challenges.bob
import de.spurowski.stutils.settings.settings.timer.challenges.enderDragon
import de.spurowski.stutils.settings.settings.timer.challenges.wither
import net.axay.kspigot.chat.col
import net.axay.kspigot.gui.GUIType
import net.axay.kspigot.gui.Slots
import net.axay.kspigot.gui.kSpigotGUI

import de.spurowski.stutils.settings.settings.timer.time.h
import de.spurowski.stutils.settings.settings.timer.time.min
import de.spurowski.stutils.settings.settings.timer.time.sec
import de.spurowski.stutils.settings.settings.timer.timer
import de.spurowski.stutils.settings.settings.timer.time.time
import de.spurowski.stutils.settings.settings.timer.countdown
import de.spurowski.stutils.settings.settings.timer.look.colorOnPaused
import de.spurowski.stutils.settings.settings.timer.look.colorOnRun
import de.spurowski.stutils.utils.calcToSec
import de.spurowski.stutils.utils.runTimer
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.extensions.broadcast

class TimerGUI {
    private val timerColor = col("green")
    val gui = kSpigotGUI(GUIType.FIVE_BY_NINE) {
        title = literalText("Timer Settings")
        defaultPage = 0

        page(0) {
            this.placeholder(Slots.RowFive, TimerDisplayItems.fill)
            this.placeholder(Slots.RowFour, TimerDisplayItems.fill)
            this.placeholder(Slots.RowThree, TimerDisplayItems.fill)
            this.placeholder(Slots.RowTwo, TimerDisplayItems.line)
            this.button(Slots.RowFiveSlotOne, TimerDisplayItems.timer()) {
                if (timer) {
                    timer = false
                    it.player.sendMessage(
                        "${getPrefix("timer")}Der$timerColor Timer " +
                                "${colors["default"]}wurde " +
                                "${colors["disable"]}deaktiviert${colors["default"]}."
                    )
                } else {
                    timer = true
                    runTimer()
                    it.player.sendMessage(
                        "${getPrefix("timer")}Der$timerColor Timer " +
                                "${colors["default"]}wurde " +
                                "${colors["enable"]}aktiviert${colors["default"]}."
                    )
                }
                it.bukkitEvent.currentItem = TimerDisplayItems.timer()
            }

            //--------------- timer.sec ----------------------
            this.button(Slots.RowFiveSlotFour, TimerDisplayItems.sec()) {
                if (it.bukkitEvent.click.isLeftClick) {
                    if(sec < 59) {
                        sec++
                        it.player.sendMessage("${getPrefix("timer")}${timerColor} Sekunden ${colors["default"]}wurde auf ${colors["value"]}$sec ${colors["default"]}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Sekunden ${colors["default"]}ist bereits auf: ${colors["value"]}$sec")
                    }
                }
                if (it.bukkitEvent.click.isRightClick) {
                    if(sec > 0) {
                        sec--
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Sekunden ${colors["default"]}wurde auf ${colors["value"]}$sec ${colors["default"]}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Sekunden ${colors["default"]}ist bereits auf: ${colors["value"]}$sec")
                    }
                }
                calcToSec()
                it.bukkitEvent.currentItem = TimerDisplayItems.sec()
            }

            //--------------- timer.min ----------------------
            this.button(Slots.RowFiveSlotFive, TimerDisplayItems.min()) {
                if (it.bukkitEvent.click.isLeftClick) {
                    if(min < 59) {
                        min++
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Minuten ${colors["default"]}wurde auf ${colors["value"]}$min ${colors["default"]}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Minuten ${colors["default"]}ist bereits auf: ${colors["value"]}$min")
                    }
                }
                if (it.bukkitEvent.click.isRightClick) {
                    if(min > 0) {
                        min--
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Minuten ${colors["default"]}wurde auf ${colors["value"]}$min ${colors["default"]}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Minuten ${colors["default"]}ist bereits auf: ${colors["value"]}$min")
                    }
                }
                calcToSec()
                it.bukkitEvent.currentItem = TimerDisplayItems.min()
            }

            //--------------- timer.h ----------------------
            this.button(Slots.RowFiveSlotSix, TimerDisplayItems.h()) {
                if (it.bukkitEvent.click.isLeftClick) {
                    if(h < 24) {
                        h++
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Stunden ${colors["default"]}wurde auf ${colors["value"]}$h ${colors["default"]}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Stunden ${colors["default"]}ist bereits auf: ${colors["value"]}$h")
                    }
                }
                if (it.bukkitEvent.click.isRightClick) {
                    if(h > 0) {
                        h--
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Stunden ${colors["default"]}wurde auf ${colors["value"]}$h ${colors["default"]}gesetzt.")
                    }
                    else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Stunden ${colors["default"]}ist bereits auf: ${colors["value"]}$h")
                    }
                }
                calcToSec()
                it.bukkitEvent.currentItem = TimerDisplayItems.h()
            }

            //--------------- timer.countdown ----------------------
            this.button(Slots.RowFiveSlotNine, TimerDisplayItems.countdown()) {
                if(countdown) {
                    countdown = false
                    it.player.sendMessage("${getPrefix("timer")}${timerColor}Countdown ${colors["default"]}wurde auf ${colors["disable"]}$countdown ${colors["default"]}gesetzt.")
                }
                else{
                    if (time != 0){
                        countdown = true
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Countdown ${colors["default"]}wurde auf ${colors["enable"]}$countdown ${colors["default"]}gesetzt.")
                    }else{
                        it.player.sendMessage("${getPrefix("timer")}${timerColor}Countdown ${colors["error"]}wurde beibehalten [${colors["enable"]}$countdown${colors["error"]}]. (null)")
                    }
                }
                it.bukkitEvent.currentItem = TimerDisplayItems.countdown()
            }

            //--------------- timer.cols ----------------------
            this.placeholder(Slots.RowThreeSlotFour, colorSelectItem(colorOnRun, itemName = "color on run - ${colors["error"]}maintenance"))
            this.placeholder(Slots.RowThreeSlotSix, colorSelectItem(colorOnPaused, itemName = "color on paused - ${colors["error"]}maintenance"))

            //--------------- timer.challenges ----------------------
            this.button(Slots.RowOneSlotOne, TimerDisplayItems.enderdragon()){
                if (!bob || !wither) enderDragon = !enderDragon
                it.bukkitEvent.currentItem = TimerDisplayItems.enderdragon()
            }
            this.button(Slots.RowOneSlotTwo, TimerDisplayItems.bob()){
                if (!enderDragon || !wither) bob = !bob
                it.bukkitEvent.currentItem = TimerDisplayItems.bob()
            }
            this.button(Slots.RowOneSlotThree, TimerDisplayItems.wither()){
                if (!bob || !enderDragon) wither = !wither
                it.bukkitEvent.currentItem = TimerDisplayItems.wither()
            }
        }
        page(1){
            //this.button(Slots.RowFiveSlotOne, colorSelectItem("black", colorOnRun)){ colorOnRun = "black"; it.bukkitEvent.currentItem = colorSelectItem("black", colorOnRun)}
            //this.button(Slots.RowFiveSlotTwo, colorSelectItem("dark_blue", colorOnRun)){ colorOnRun = "dark_blue"; it.bukkitEvent.currentItem = colorSelectItem("dark_blue", colorOnRun)}
            //this.button(Slots.RowFiveSlotThree, colorSelectItem("dark_green", colorOnRun)){ colorOnRun = "dark_green"; it.bukkitEvent.currentItem = colorSelectItem("dark_green", colorOnRun)}
            //this.button(Slots.RowFiveSlotFour, colorSelectItem("dark_aqua", colorOnRun)){ colorOnRun = "dark_aqua"; it.bukkitEvent.currentItem = colorSelectItem("dark_aqua", colorOnRun)}
            //this.button(Slots.RowFiveSlotFive, colorSelectItem("dark_red", colorOnRun)){ colorOnRun = "dark_red"; it.bukkitEvent.currentItem = colorSelectItem("dark_red", colorOnRun)}
            //this.button(Slots.RowFiveSlotSix, colorSelectItem("dark_purple", colorOnRun)){ colorOnRun = "dark_purple"; it.bukkitEvent.currentItem = colorSelectItem("dark_purple", colorOnRun)}
            //this.button(Slots.RowFiveSlotSeven, colorSelectItem("gold", colorOnRun)){ colorOnRun = "gold"; it.bukkitEvent.currentItem = colorSelectItem("gold", colorOnRun)}
            //this.button(Slots.RowFiveSlotEight, colorSelectItem("gray", colorOnRun)){ colorOnRun = "gray"; it.bukkitEvent.currentItem = colorSelectItem("gray", colorOnRun)}
            //this.button(Slots.RowFiveSlotNine, colorSelectItem("dark_gray", colorOnRun)){ colorOnRun = "black"; it.bukkitEvent.currentItem = colorSelectItem("dark_gray", colorOnRun)}
            //this.button(Slots.RowFourSlotOne, colorSelectItem("blue", colorOnRun)){ colorOnRun = "blue"; it.bukkitEvent.currentItem = colorSelectItem("blue", colorOnRun)}
            //this.button(Slots.RowFourSlotTwo, colorSelectItem("green", colorOnRun)){ colorOnRun = "green"; it.bukkitEvent.currentItem = colorSelectItem("green", colorOnRun)}
            //this.button(Slots.RowFourSlotThree, colorSelectItem("aqua", colorOnRun)){ colorOnRun = "aqua"; it.bukkitEvent.currentItem = colorSelectItem("aqua", colorOnRun)}
            //this.button(Slots.RowFourSlotFour, colorSelectItem("red", colorOnRun)){ colorOnRun = "red"; it.bukkitEvent.currentItem = colorSelectItem("red", colorOnRun)}
            //this.button(Slots.RowFourSlotFive, colorSelectItem("light_purple", colorOnRun)){ colorOnRun = "light_purple"; it.bukkitEvent.currentItem = colorSelectItem("light_purple", colorOnRun)}
            //this.button(Slots.RowFourSlotSix, colorSelectItem("yellow", colorOnRun)){ colorOnRun = "black"; it.bukkitEvent.currentItem = colorSelectItem("yellow", colorOnRun)}
            //this.button(Slots.RowFourSlotSeven, colorSelectItem("white", colorOnRun)){ colorOnRun = "black"; it.bukkitEvent.currentItem = colorSelectItem("white", colorOnRun)}
            //this.pageChanger(Slots.RowOneSlotNine, TimerDisplayItems.back, 0, null)
        }
        page(2){
            /*this.button(Slots.RowFiveSlotOne, colorSelectItem("black", colorOnPaused)){ colorOnPaused = "black"; it.bukkitEvent.currentItem = colorSelectItem("black", colorOnPaused)}
            this.button(Slots.RowFiveSlotTwo, colorSelectItem("dark_blue", colorOnPaused)){ colorOnPaused = "dark_blue"; it.bukkitEvent.currentItem = colorSelectItem("dark_blue", colorOnPaused)}
            this.button(Slots.RowFiveSlotThree, colorSelectItem("dark_green", colorOnPaused)){ colorOnPaused = "dark_green"; it.bukkitEvent.currentItem = colorSelectItem("dark_green", colorOnPaused)}
            this.button(Slots.RowFiveSlotFour, colorSelectItem("dark_aqua", colorOnPaused)){ colorOnPaused = "dark_aqua"; it.bukkitEvent.currentItem = colorSelectItem("dark_aqua", colorOnPaused)}
            this.button(Slots.RowFiveSlotFive, colorSelectItem("dark_red", colorOnPaused)){ colorOnPaused = "dark_red"; it.bukkitEvent.currentItem = colorSelectItem("dark_red", colorOnPaused)}
            this.button(Slots.RowFiveSlotSix, colorSelectItem("dark_purple", colorOnPaused)){ colorOnPaused = "dark_purple"; it.bukkitEvent.currentItem = colorSelectItem("dark_purple", colorOnPaused)}
            this.button(Slots.RowFiveSlotSeven, colorSelectItem("gold", colorOnPaused)){ colorOnPaused = "gold"; it.bukkitEvent.currentItem = colorSelectItem("gold", colorOnPaused)}
            this.button(Slots.RowFiveSlotEight, colorSelectItem("gray", colorOnPaused)){ colorOnPaused = "gray"; it.bukkitEvent.currentItem = colorSelectItem("gray", colorOnPaused)}
            this.button(Slots.RowFiveSlotNine, colorSelectItem("dark_gray", colorOnPaused)){ colorOnPaused = "black"; it.bukkitEvent.currentItem = colorSelectItem("dark_gray", colorOnPaused)}
            this.button(Slots.RowFourSlotOne, colorSelectItem("blue", colorOnPaused)){ colorOnPaused = "blue"; it.bukkitEvent.currentItem = colorSelectItem("blue", colorOnPaused)}
            this.button(Slots.RowFourSlotTwo, colorSelectItem("green", colorOnPaused)){ colorOnPaused = "green"; it.bukkitEvent.currentItem = colorSelectItem("green", colorOnPaused)}
            this.button(Slots.RowFourSlotThree, colorSelectItem("aqua", colorOnPaused)){ colorOnPaused = "aqua"; it.bukkitEvent.currentItem = colorSelectItem("aqua", colorOnPaused)}
            this.button(Slots.RowFourSlotFour, colorSelectItem("red", colorOnPaused)){ colorOnPaused = "red"; it.bukkitEvent.currentItem = colorSelectItem("red", colorOnPaused)}
            this.button(Slots.RowFourSlotFive, colorSelectItem("light_purple", colorOnPaused)){ colorOnPaused = "light_purple"; it.bukkitEvent.currentItem = colorSelectItem("light_purple", colorOnPaused)}
            this.button(Slots.RowFourSlotSix, colorSelectItem("yellow", colorOnPaused)){ colorOnPaused = "black"; it.bukkitEvent.currentItem = colorSelectItem("yellow", colorOnPaused)}
            this.button(Slots.RowFourSlotSeven, colorSelectItem("white", colorOnPaused)){ colorOnPaused = "black"; it.bukkitEvent.currentItem = colorSelectItem("white", colorOnPaused)}*/
            //this.pageChanger(Slots.RowOneSlotNine, TimerDisplayItems.back, 0, null)
        }
    }
}
