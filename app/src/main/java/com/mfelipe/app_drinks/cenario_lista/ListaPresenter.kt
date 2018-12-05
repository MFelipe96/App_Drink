package com.mfelipe.app_drinks.cenario_lista

import com.mfelipe.app_drinks.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ListaPresenter(val view : ListaContract.View): ListaContract.Presenter {


    override fun carregaLista() {
        val newServices = RetrofitInicializer().createNewService()

        val call = newServices.getDrinksAlcoolicos()

        call.enqueue(object : Callback<DrinksList> {
            override fun onFailure(call: Call<DrinksList>?, t: Throwable?) {

                view.showMessage("Falha na conexão. ")
            }

            override fun onResponse(call: Call<DrinksList>, response: Response<DrinksList>) {
                if(response.body() != null){
                    view.showList(response.body()!!.drinks)
                }else{
                    view.showMessage("Estamos sem drinks hoje.")
                }
            }

        })
    }

}