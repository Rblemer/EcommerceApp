package br.com.ecommerce_app.ui.screens.favorite

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.common.ScreenState
import br.com.ecommerce_app.domain.entity.product.FavoriteProductEntity
import br.com.ecommerce_app.domain.mapper.ProductBaseMapper
import br.com.ecommerce_app.domain.mapper.ProductListMapper
import br.com.ecommerce_app.domain.usecase.favorite.DeleteFavoriteUseCase
import br.com.ecommerce_app.domain.usecase.favorite.FavoriteUseCase
import br.com.ecommerce_app.ui.uiData.FavoriteUiData
import br.com.ecommerce_app.utils.getUserIdFromSharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteUseCase: FavoriteUseCase,
    private val mapper: ProductListMapper<FavoriteProductEntity, FavoriteUiData>,
    private val singleMapper: ProductBaseMapper<FavoriteUiData, FavoriteProductEntity>,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    private val _favoriteCarts = MutableLiveData<ScreenState<List<FavoriteUiData>>>()
    val favoriteCarts: LiveData<ScreenState<List<FavoriteUiData>>> get() = _favoriteCarts

    init {
        getFavoriteProducts()
    }

    private fun getFavoriteProducts() {
        viewModelScope.launch {
            favoriteUseCase.invoke(getUserIdFromSharedPref(sharedPreferences)).collect {
                when (it) {
                    is NetworkResponseState.Error -> _favoriteCarts.postValue(
                        ScreenState.Error(
                            it.exception.message!!,
                        ),
                    )

                    is NetworkResponseState.Loading -> _favoriteCarts.postValue(ScreenState.Loading)
                    is NetworkResponseState.Success -> _favoriteCarts.postValue(
                        ScreenState.Success(
                            mapper.map(it.result),
                        ),
                    )
                }
            }
        }
    }

    fun deleteFavoriteItem(favoriteUiData: FavoriteUiData) {
        viewModelScope.launch {
            deleteFavoriteUseCase(singleMapper.map(favoriteUiData))
            getFavoriteProducts()
        }
    }
}
