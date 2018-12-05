package com.mfelipe.app_drinks.network

import retrofit2.Call
import com.mfelipe.app_drinks.cenario_lista.DrinksList
import retrofit2.http.GET

interface NewServices {

    companion object {
        private const val API_KEY = "1"
    }

    @GET("$API_KEY/filter.php?&a=Alcoholic")
    fun getDrinksAlcoolicos(): Call<DrinksList>

    @GET("$API_KEY/search.php?&s=margarita")
    fun getInstrucoesDrinks(): Call<DrinksList>
}