package net.micg.habitmaster.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.micg.habitmaster.presenter.navigation.AppNavigator
import net.micg.habitmaster.presenter.theme.HabitMasterTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.updateStartDestination()
        enableEdgeToEdge()
        setContent(content = { ActivityContent() })
    }

    @Composable
    private fun ActivityContent() {
        val destination = viewModel.startDestination
        if (destination == null) return

        HabitMasterTheme {
            Scaffold(Modifier.fillMaxSize()) { innerPadding ->
                AppNavigator(Modifier.padding(innerPadding), destination)
            }
        }
    }
}
