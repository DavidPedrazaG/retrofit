package eam.retrtofit

import android.app.Application
import eam.retrtofit.data.AppContainer
import eam.retrtofit.data.DefaultAppContainer

class MarvelCharactersApplication : Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}