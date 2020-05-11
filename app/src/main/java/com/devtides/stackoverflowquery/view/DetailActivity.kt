package com.devtides.stackoverflowquery.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devtides.stackoverflowquery.R
import com.devtides.stackoverflowquery.model.Question

class DetailActivity : AppCompatActivity() {

    companion object {
        const val PARAM_QUESTION = "param_question"

        fun getIntent(context : Context, question : Question) =
            Intent(context, DetailActivity::class.java).putExtra(PARAM_QUESTION, question)
    }

    var question : Question? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        question = intent.extras?.getParcelable(PARAM_QUESTION)
        if(question == null) {
            finish()
        }
    }
}
