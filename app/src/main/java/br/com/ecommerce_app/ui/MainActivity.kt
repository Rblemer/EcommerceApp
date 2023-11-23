package br.com.ecommerce_app.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat.getSystemService
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.ecommerce_app.R
import br.com.ecommerce_app.navigation.AppBottomNavBar
import br.com.ecommerce_app.navigation.AppNavHost
import br.com.ecommerce_app.navigation.SignIn
import br.com.ecommerce_app.navigation.SignUp
import br.com.ecommerce_app.navigation.Splash
import br.com.ecommerce_app.ui.theme.AppTheme
import br.com.ecommerce_app.ui.screens.cart.CartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                val cartViewModel: CartViewModel = hiltViewModel()
                val badgeCount by cartViewModel.badgeCount.collectAsState()
                App(badgeCount = badgeCount) { newBadgeCount ->
                    cartViewModel.updateBadgeCount(newBadgeCount)
                }
            }
        }
    }
}

@Composable
fun App(
    modifier: Modifier = Modifier,
    appState: EcommerceAppState = rememberEcommerceAppState(),
    badgeCount: Int,
    onBadgeCountChange: (Int) -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        if (!appState.isOnline) {
            OfflineDialog(onRetry = appState::refreshOnline)
        } else {
            val navController = rememberNavController()
            val bottomBarState = rememberSaveable { (mutableStateOf(false)) }
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            when (navBackStackEntry?.destination?.route) {
                SignIn.route, SignUp.route, Splash.route -> bottomBarState.value = false
                else -> bottomBarState.value = true
            }

            Scaffold(
                bottomBar = {
                    if (bottomBarState.value) {
                        AppBottomNavBar(
                            navController = navController,
                            bottomBarState = bottomBarState,
                            badgeState = badgeCount,
                        )
                    }
                },
            ) { paddingValues ->
                AppNavHost(
                    navController = navController,
                    modifier = Modifier.padding(paddingValues),
                    onBadgeCountChange = onBadgeCountChange,
                )
            }
        }
    }
}

@Composable
fun rememberEcommerceAppState(
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current,
) = remember(navController, context) {
    EcommerceAppState(navController, context)
}

class EcommerceAppState(
    val navController: NavHostController,
    private val context: Context,
) {
    var isOnline by mutableStateOf(checkIfOnline())
        private set

    fun refreshOnline() {
        isOnline = checkIfOnline()
    }

    fun navigateToSignIn(from: NavBackStackEntry) {
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigate(SignIn.route)
        }
    }

    fun navigateBack() {
        navController.popBackStack()
    }

    private fun checkIfOnline(): Boolean {
        val cm = getSystemService(context, ConnectivityManager::class.java)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val capabilities = cm?.getNetworkCapabilities(cm.activeNetwork) ?: return false
            capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } else {
            cm?.activeNetworkInfo?.isConnectedOrConnecting == true
        }
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED

@Composable
fun OfflineDialog(onRetry: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = stringResource(R.string.app_name)) },
        text = { Text(text = stringResource(R.string.no_internet_connection_dialog)) },
        confirmButton = {
            TextButton(onClick = onRetry) {
                Text(stringResource(R.string.retry))
            }
        },
    )
}
