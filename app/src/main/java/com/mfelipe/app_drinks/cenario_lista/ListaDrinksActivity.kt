package com.mfelipe.app_drinks.cenario_lista

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.menu.ShowableListMenu
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.mfelipe.app_drinks.MainActivity
import com.mfelipe.app_drinks.R
import com.mfelipe.app_drinks.entidade.Drinks
import kotlinx.android.synthetic.main.activity_lista_bebidas.*

class ListaDrinksActivity : AppCompatActivity(), ListaContract.View {


    private val mOnNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val paginaInicial = Intent(this, ListaDrinksActivity::class.java)
                startActivity(paginaInicial)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_perfil -> {
                val telaPerfil = Intent(this, MainActivity::class.java)
                startActivity(telaPerfil)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favoritos -> {
                //message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_bebidas)

        val presenter : ListaContract.Presenter = ListaPresenter(this)
        presenter.carregaLista()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun showList(lista: List<Drinks>) {

        // obrigatorios para termos um recycler view
        val adapter = DrinkAdapter(this, lista)
        val layoutManager = LinearLayoutManager(this)

        adapter.ConfiguraClique {

            //val exibirDetalhes = Intent(this, ExibeDetalhesActivity::class.java)
            //this.startActivity(exibirDetalhes)
        }

        rvListaBebidas.adapter = adapter
        rvListaBebidas.layoutManager = layoutManager
    }


    override fun showMessage(msg: String) {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


}
