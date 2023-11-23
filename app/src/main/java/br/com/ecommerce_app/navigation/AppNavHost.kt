package br.com.ecommerce_app.navigation // ktlint-disable package-name

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.ecommerce_app.ui.screens.auth.SignInRoute
import br.com.ecommerce_app.ui.screens.auth.SignUpRoute
import br.com.ecommerce_app.ui.screens.cart.CartRoute
import br.com.ecommerce_app.ui.screens.detail.DetailRoute
import br.com.ecommerce_app.ui.screens.favorite.FavoriteRoute
import br.com.ecommerce_app.ui.screens.home.HomeRoute
import br.com.ecommerce_app.ui.screens.payment.PaymentRoute
import br.com.ecommerce_app.ui.screens.profile.ProfileRoute
import br.com.ecommerce_app.ui.screens.splash.SplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onBadgeCountChange: (Int) -> Unit
) {
    NavHost(navController = navController, startDestination = Splash.route, modifier = modifier) {
        composable(Splash.route) {
            SplashScreen(
                navigateToHomeScreen = {
                    navController.navigate(SignIn.route)
                },
            )
        }

        composable(Home.route) {
            HomeRoute(
                onProductClicked = {
                    val route = "${ProductDetail.route}/${it.id}"
                    navController.navigate(route = route)
                },
            )
        }
        composable(ProductDetail.routeWithArgs, arguments = ProductDetail.arguments) {
            DetailRoute(
                onBadgeCountChange = onBadgeCountChange,
            )
        }
        composable(Cart.route) {
            CartRoute(
                onClickedBuyNowButton = {
                    navController.navigate(Payment.route)
                },
                onCartClicked = {
                    val route = "${ProductDetail.route}/${it.productId}"
                    navController.navigate(route = route)
                },
                onBadgeCountChange = onBadgeCountChange,
            )
        }
        composable(Profile.route) {
            ProfileRoute(
                logout = {
                    navController.navigate(SignIn.route) {
                        popUpTo(SignIn.route) {
                            inclusive = true
                        }
                    }
                },
            )
        }
        composable(SignIn.route) {
            SignInRoute(
                onGoSignUpButtonClicked = {
                    navController.navigate(SignUp.route)
                },
                navigateToHomeScreen = {
                    navController.navigate(Home.route)
                },
            )
        }
        composable(SignUp.route) {
            SignUpRoute(
                navigateToSignInScreen = {
                    navController.navigate(SignIn.route)
                },
            )
        }
        composable(Favorite.route) {
            FavoriteRoute(
                onProductClicked = {
                    val route = "${ProductDetail.route}/${it.productId}"
                    navController.navigate(route = route)
                },
            )
        }
        composable(Payment.route) {
            PaymentRoute()
        }
    }
}
