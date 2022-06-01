package de.spurowski.stutils

import de.spurowski.stutils.JMain.*
import de.spurowski.stutils.settings.Config
import de.spurowski.stutils.settings.settings
import de.spurowski.stutils.utils.Commands
import de.spurowski.stutils.utils.worldsettings.worldListener
import net.axay.kspigot.main.KSpigot

class InternalMainClass : KSpigot() {

    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }


    override fun load() {
        INSTANCE = this
        var config = Config()
        settings.load()
        JMain().tOnLoad()
    }

    override fun startup() {
        setGets()
        JMain().tOnEnable()
        Listener()
        Commands()
        worldListener()
    }

    override fun shutdown() {
        JMain().tOnDisable()
        de.spurowski.stutils.settings.save()
        settings.save()
    }
}