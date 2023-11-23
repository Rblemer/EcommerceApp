package br.com.ecommerce_app.ui.screens.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.ecommerce_app.common.ScreenState
import br.com.ecommerce_app.ui.Error
import br.com.ecommerce_app.ui.Loading
import br.com.ecommerce_app.ui.uiData.UserCartUiData
import br.com.ecommerce_app.utils.toBrazilianCurrency

@Composable
fun CartRoute(
    viewModel: CartViewModel = hiltViewModel(),
    onClickedBuyNowButton: () -> Unit,
    onCartClicked: (UserCartUiData) -> Unit,
    onBadgeCountChange: (Int) -> Unit
) {
    val cartState by viewModel.userCarts.observeAsState(initial = ScreenState.Loading)
    val onCartLongClicked = { cartUiData: UserCartUiData ->
        viewModel.deleteUserCartItem(cartUiData)
        onBadgeCountChange(viewModel.badgeCount.value.minus(1))
    }


    val updateTotalAmount = { uiData: List<UserCartUiData> ->
        viewModel.updateTotalPrice(uiData)
    }

    val onDecrement = { cartUiData: UserCartUiData ->
        if (cartUiData.quantity > 1) {
            viewModel.updateUserCartItem(cartUiData.copy(quantity = cartUiData.quantity - 1))
        }
    }

    val onIncrement = { cartUiData: UserCartUiData ->
        viewModel.updateUserCartItem(cartUiData.copy(quantity = cartUiData.quantity + 1))
    }

    when (cartState) {
        is ScreenState.Loading -> {
            Loading()
        }

        is ScreenState.Error -> {
            Error(message = (cartState as ScreenState.Error).message)
        }

        is ScreenState.Success -> {
            viewModel.updateTotalPrice((cartState as ScreenState.Success<List<UserCartUiData>>).uiData)
            val totalPrice by viewModel.totalPriceLiveData.observeAsState(initial = 0.0)
            SuccessScreen(
                uiData = (cartState as ScreenState.Success).uiData,
                modifier = Modifier.padding(16.dp),
                onCartClicked = onCartClicked,
                onCartLongClicked = onCartLongClicked,
                onClickedBuyNowButton = onClickedBuyNowButton,
                totalPrice = totalPrice,
                onDecrement = onDecrement,
                onIncrement = onIncrement,
                updateTotalAmount = updateTotalAmount,
            )
        }
    }

}

@Composable
fun SuccessScreen(
    uiData: List<UserCartUiData>,
    modifier: Modifier = Modifier,
    onClickedBuyNowButton: () -> Unit,
    onCartClicked: (UserCartUiData) -> Unit,
    onCartLongClicked: (UserCartUiData) -> Unit,
    totalPrice: Double,
    onDecrement: (UserCartUiData) -> Unit,
    onIncrement: (UserCartUiData) -> Unit,
    updateTotalAmount: (List<UserCartUiData>) -> Unit,
    ) {
    Box(modifier = modifier) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(uiData.size) { cart ->
                CartItem(
                    cartUiData = uiData[cart],
                    onCartItemClicked = onCartClicked,
                    onCartLongClicked = onCartLongClicked,
                    onIncrement = {
                        onIncrement(uiData[cart])
                        updateTotalAmount(uiData)
                    },
                    onDecrement = {
                        onDecrement(uiData[cart])
                        updateTotalAmount(uiData)
                    },
                )
            }
        }
        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            ),
            shape = RoundedCornerShape(10.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Preço Total:",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                        ),
                        modifier = Modifier
                            .weight(1f),
                    )
                    Text(
                        text = totalPrice.toBigDecimal().toBrazilianCurrency(),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }

                Button(
                    onClick = { onClickedBuyNowButton() },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(text = "Comprar agora")
                }
            }
        }
    }
}