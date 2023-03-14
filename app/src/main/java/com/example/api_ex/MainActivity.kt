package com.example.api_ex


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.api_ex.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var apiInterface=ApiClient.getApiclient().create(ApiInterface::class.java)

        apiInterface.getusers().enqueue(object :Callback<Users>{
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful){

                    val model:Users=response.body()!!

                    binding.recycle.layoutManager=GridLayoutManager(this@MainActivity,1)
                    binding.recycle.adapter= UsersAdapter(model.users)
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e(TAG, "onFailure: Faill" + t.message)
            }

        })


    }
}