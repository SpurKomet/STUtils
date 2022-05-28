package de.spurowski.stutils

import de.spurowski.stutils.JMain.*
import de.spurowski.stutils.settings.Config
import de.spurowski.stutils.settings.settings
import de.spurowski.stutils.utils.Commands
import net.axay.kspigot.main.KSpigot

class InternalMainClass : KSpigot() {

    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }


    override fun load() {
        INSTANCE = this
        var config = Config()
        tOnLoad()
        settings.load()
    }

    override fun startup() {
        tOnEnable()
        Listener()
        setGets()
        Commands()
    }

    override fun shutdown() {
        tOnDisable()
        de.spurowski.stutils.settings.save()
        settings.save()
    }
}