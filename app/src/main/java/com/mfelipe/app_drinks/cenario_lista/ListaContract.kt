package com.mfelipe.app_drinks.cenario_lista

import com.mfelipe.app_drinks.entidade.Drinks

interface ListaContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(drinks: List<Drinks>)

    }

    interface Presenter{

            fun carregaLista()
    }
}