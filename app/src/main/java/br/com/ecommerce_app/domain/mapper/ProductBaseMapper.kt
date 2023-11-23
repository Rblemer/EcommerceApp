package br.com.ecommerce_app.domain.mapper

interface ProductBaseMapper<I, O> {
    fun map(input: I): O
}
