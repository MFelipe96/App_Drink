package com.mfelipe.app_drinks.cenario_lista

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.bumptech.glide.request.RequestOptions
import com.mfelipe.app_drinks.R
import com.mfelipe.app_drinks.entidade.Drinks
import com.mfelipe.app_drinks.uteis.GlideApp
import kotlinx.android.synthetic.main.drink_item_lista.view.*

class DrinkAdapter(val context: Context, val drinks: List<Drinks>)
    : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    var clique: ((drinks: Drinks) -> Unit)? = null


    //metodo responsavel por inflar as views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.drink_item_lista, parent, false)
        return ViewHolder(view)
    }
    //metodo responsavel por saber o tamanho dessa lista
    override fun getItemCount(): Int {
        return drinks.size //retorno o tamanho da lista
    }
    //coloca as informações dos drinks no viewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, drinks[position], clique) //passando a posição a ser alterada
    }

    fun ConfiguraClique(clique: ((drinks: Drinks) -> Unit)){
        this.clique = clique
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, drinks: Drinks, clique: ((drinks: Drinks) -> Unit)?) {
            itemView.tvNome.text = drinks.strDrink

            //começo da gambiarra
            val thumbnail = GlideApp.with(context)
                    .load(R.drawable.ic_local_bar)
                    .apply(RequestOptions().circleCrop())

            GlideApp.with(context)
                    .load(drinks.strDrinkThumb)
                    .thumbnail(thumbnail) //fim da gabiarra
                    .centerCrop()
                    .apply(RequestOptions().circleCrop())
                    .into(itemView.ivImagem)

            if(clique != null) {

                itemView.setOnClickListener() {

                    clique.invoke(drinks)

                }
            }
        }

    }
}