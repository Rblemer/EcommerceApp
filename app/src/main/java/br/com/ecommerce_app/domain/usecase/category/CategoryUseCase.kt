package br.com.ecommerce_app.domain.usecase.category

import br.com.ecommerce_app.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {
    operator fun invoke(): Flow<NetworkResponseState<List<String>>>
}
