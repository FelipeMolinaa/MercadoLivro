package com.cabret.projetoler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cabret.projetoler.fragments.CarrinhoFragment
import com.cabret.projetoler.fragments.HomeFragment
import com.cabret.projetoler.fragments.ListaFragment
import com.cabret.projetoler.fragments.LivroDetailFragment
import com.cabret.projetoler.fragments.PerfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val AtualFragmentVal = 1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentVal = 1
        loadFragment(HomeFragment(), fragmentVal);

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId){
                R.id.inicio ->{
                    loadFragment(HomeFragment(), 1)
                    true
                }
                R.id.lista ->{
                    loadFragment(ListaFragment(), 2)
                    true
                }
                R.id.carrinho ->{
                    loadFragment(CarrinhoFragment(),3)
                    true
                }
                R.id.perfil ->{
                    loadFragment(PerfilFragment(),4)
                    true
                }

                else -> {true}
            }
        }

        findViewById<FloatingActionButton>(R.id.usuarioFAB).setOnClickListener{
            loadFragment(PerfilFragment(),4)
        }
    }

    fun loadFragment(fragment: Fragment, fragmentVal: Int){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}