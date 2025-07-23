package net.micg.habitmaster.utils

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import net.micg.habitmaster.feature.authorization.presenter.ui.screenSignIn.SignInScreen
import net.micg.habitmaster.feature.authorization.presenter.ui.screenSignIn.SignInViewModel
import net.micg.habitmaster.presenter.theme.HabitMasterTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.getValue

class MainActivity : ComponentActivity() {
    private val viewModel: SignInViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitMasterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignInScreen(viewModel, Modifier.padding(innerPadding))
                }
            }
        }
    }
}
