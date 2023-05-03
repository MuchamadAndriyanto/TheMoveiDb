package com.example.themoveidb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoveidb.databinding.ActivityMainBinding
import com.example.themoveidb.model.MovieTopRated
import com.example.themoveidb.model.Result
import com.example.themoveidb.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val listFilm = mutableListOf<com.example.themoveidb.model.Result>()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getFilm()
    }


    fun getFilm(){
        RetrofitClient.instance.getmovietoprated(APIKEY = "5eadf04193e2a9bcea8a8e8f4cfa89e2", PAGE = 1)
            .enqueue(object : Callback<MovieTopRated<com.example.themoveidb.model.Result>> {
                override fun onResponse(
                    call: Call<MovieTopRated<com.example.themoveidb.model.Result>>,
                    response: Response<MovieTopRated<com.example.themoveidb.model.Result>>
                ) {
                    if (response.isSuccessful){
                        binding.rvFilm.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                        val filmResponse = response.body()
                        if(filmResponse != null){
                            listFilm.addAll(filmResponse.results)
                            binding.rvFilm.adapter = MovieAdapter(listFilm)
                        }
                    }else{
                        Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<MovieTopRated<Result>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
                }

            })

    }

}
