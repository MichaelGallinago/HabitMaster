package net.micg.habitmaster.presenter.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.micg.habitmaster.di.modules.AppModule.appModule
import net.micg.habitmaster.di.modules.DataBaseModule.dataBaseModule
import net.micg.habitmaster.di.modules.DataModule.dataModule
import net.micg.habitmaster.feature.authorization.presenter.ui.screenSignIn.SignInScreen
import net.micg.habitmaster.presenter.theme.HabitMasterTheme
import org.koin.compose.KoinApplication
import org.koin.compose.KoinApplicationPreview
import org.koin.core.KoinApplication

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinApplicationPreview(application = { modules(
                dataModule,
                dataBaseModule,
                *appModule.toTypedArray(),)
            }) {
                HabitMasterTheme {
                    Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                        SignInScreen(modifier = Modifier.Companion.padding(innerPadding))
                    }
                }
            }
        }
    }
}
