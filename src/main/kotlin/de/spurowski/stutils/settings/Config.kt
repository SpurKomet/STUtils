package de.spurowski.stutils.settings

import de.spurowski.stutils.InternalMainClass
import de.spurowski.stutils.settings.settings.configuration
import de.spurowski.stutils.settings.settings.dir
import de.spurowski.stutils.settings.settings.file
import net.kyori.adventure.text.format.TextColor
import java.io.IOException


fun Config(){
    if (!dir.exists()) {
        dir.mkdirs()
    }

    if (!file.exists()){
        try {
            file.createNewFile()
        }catch (e: IOException){
            e.printStackTrace()
        }
    }

}
fun save(){
    try {
        configuration.save(file)
    }catch (e: IOException){
        e.printStackTrace()
    }
}



fun Boolean.setConf(path: String){
    InternalMainClass.INSTANCE.config.set(path, this)
}
fun Int.setConf(path: String){
    InternalMainClass.INSTANCE.config.set(path, this)
}
fun TextColor.setConf(path: String){
    InternalMainClass.INSTANCE.config.set(path, this)
}

fun getConf(path: String, orginal: Boolean): Boolean{
    var ret: Boolean = orginal
    if (configuration.contains(path)){ret = configuration.getBoolean(path)}
    return ret
}
fun getConf(path: String, orginal: Int): Int{
    var ret: Int = orginal
    if (configuration.contains(path)){ret = configuration.getInt(path)}
    return ret
}
/*fun getConf(path: String, orginal: TextColor): Int{
    var ret: TextColor = orginal
    if (configuration.contains(path)){ret = configuration.getString(path)}
    return ret
}*/