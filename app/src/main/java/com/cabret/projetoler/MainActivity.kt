package com.cabret.projetoler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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
    }

    private  fun loadFragment(fragment: Fragment, fragmentVal: Int){
        val transaction = supportFragmentManager.beginTransaction()
        if(fragmentVal > AtualFragmentVal){
            transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        }else{
            transaction.setCustomAnimations(R.anim.slide_out_left, R.anim.slide_in_right);
        }
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}