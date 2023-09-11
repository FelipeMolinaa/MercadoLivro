package com.cabret.projetoler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.cabret.projetoler.fragments.CarrinhoFragment
import com.cabret.projetoler.fragments.HomeFragment
import com.cabret.projetoler.fragments.ListaFragment
import com.cabret.projetoler.fragments.PerfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadFragment(HomeFragment());

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId){
                R.id.inicio ->{
                    loadFragment(HomeFragment())
                    true
                }
                R.id.lista ->{
                    loadFragment(ListaFragment())
                    true
                }
                R.id.carrinho ->{
                    loadFragment(CarrinhoFragment())
                    true
                }
                R.id.perfil ->{
                    loadFragment(PerfilFragment())
                    true
                }

                else -> {true}
            }
        }

        findViewById<FloatingActionButton>(R.id.usuarioFAB).setOnClickListener{
            loadFragment(PerfilFragment())
        }

    }

    fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}