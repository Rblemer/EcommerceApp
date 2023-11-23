package br.com.ecommerce_app.ui.screens.auth.viewModels // ktlint-disable package-name

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ecommerce_app.domain.entity.user.UserInformationEntity
import br.com.ecommerce_app.domain.mapper.ProductBaseMapper
import br.com.ecommerce_app.domain.usecase.user.sign_up.FirebaseUserSignUpUseCase
import br.com.ecommerce_app.domain.usecase.user.write_user.WriteFirebaseUserInfosUseCase
import br.com.ecommerce_app.common.ScreenState
import br.com.ecommerce_app.ui.uiData.UserInformationUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: FirebaseUserSignUpUseCase,
    private val writeFirebaseUserInfosUseCase: WriteFirebaseUserInfosUseCase,
    private val userInfoToEntity: ProductBaseMapper<UserInformationUiData, UserInformationEntity>,
) : ViewModel() {
    private val _signUp = MutableLiveData<ScreenState<UserInformationUiData>>()
    val signUp: LiveData<ScreenState<UserInformationUiData>> get() = _signUp

    fun signUp(user: UserInformationUiData) {
        _signUp.value = ScreenState.Loading
        viewModelScope.launch {
            signUpUseCase.invoke(
                userInfoToEntity.map(user),
                onSuccess = {
                    _signUp.postValue(ScreenState.Success(user))
                    writeUserToFirebaseDatabase(userInfoToEntity.map(user))
                },
            ) {
                _signUp.postValue(ScreenState.Error(it))
            }
        }
    }

    private fun writeUserToFirebaseDatabase(user: UserInformationEntity) {
        viewModelScope.launch {
            writeFirebaseUserInfosUseCase.invoke(
                user,
                onSuccess = {},
            ) {
                _signUp.postValue(ScreenState.Error(it))
            }
        }
    }
}
