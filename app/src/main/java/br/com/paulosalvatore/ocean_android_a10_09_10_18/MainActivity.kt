package br.com.paulosalvatore.ocean_android_a10_09_10_18

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val urlImagem = "https://img.global.news.samsung.com/br/wp-content/uploads/2017/08/20170814_195142.jpg"
//		Picasso.get().load(urlImagem).into(ivImagem)
		Glide.with(this).load(urlImagem).into(ivImagem)
	}
}
