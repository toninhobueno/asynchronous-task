package com.everis.bootcamp.threading

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: 018 - fazer o handle do clique do botão
    }




    fun showData(list: List<AstrosPeople>?){

        text_data.text = ""
        list?.forEach{ people ->
            text_data.append("${people.name} - ${people.craft} \n\n")

        }
    }


        fun showLoadingIndicator(){
            progressbar_load_indication.visibility = View.VISIBLE
        }


    fun hideLoadingIndicator (){
        progressbar_load_indication.visibility = View.GONE
    }

    //TODO: 017 - Criar função para lançar a Task




    inner class TaskAstros() : AsyncTask<Void, Int, List<AstrosPeople>>(){

        val repository = AstrosRepository()

        override fun onPreExecute() {
            super.onPreExecute()
            showLoadingIndicator ()
        }

        override fun doInBackground(vararg params: Void?): List<AstrosPeople> {

           return repository.loadData()

        }

        override fun onPostExecute(result: List<AstrosPeople>?) {
            super.onPostExecute(result)
            hideLoadingIndicator()
            showData(result)
        }


    }
}
