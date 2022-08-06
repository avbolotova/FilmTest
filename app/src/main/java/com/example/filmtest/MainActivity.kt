package com.example.filmtest

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var filmList: ArrayList<Films>
    private lateinit var filmsAdapter: FilmsAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        filmList = ArrayList()

        filmList.add(
            Films(
                R.drawable.interstellar,
                "Интерстеллар",
                "Когда засуха, пыльные бури и вымирание растений приводят человечество к продовольственному кризису, коллектив исследователей и учёных отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешествий человека и найти планету с подходящими для человечества условиями."
            )
        )

        filmList.add(
            Films(
                R.drawable.forrest_gump,
                "Форест Гамп",
                "Сидя на автобусной остановке, Форрест Гамп — не очень умный, но добрый и открытый парень — рассказывает случайным встречным историю своей необыкновенной жизни. С самого малолетства парень страдал от заболевания ног, соседские мальчишки дразнили его, но в один прекрасный день Форрест открыл в себе невероятные способности к бегу. Подруга детства Дженни всегда его поддерживала и защищала, но вскоре дороги их разошлись."
            )
        )
        filmList.add(
            Films(
                R.drawable.green_mile,
                "Зеленая миля",
                "Пол Эджкомб — начальник блока смертников в тюрьме «Холодная гора», каждый из узников которого однажды проходит «зеленую милю» по пути к месту казни. Пол повидал много заключённых и надзирателей за время работы. Однако гигант Джон Коффи, обвинённый в страшном преступлении, стал одним из самых необычных обитателей блока."
            )
        )
        filmList.add(
            Films(
                R.drawable.inceptoin,
                "Начало",
                "Кобб – талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим. Редкие способности Кобба сделали его ценным игроком в привычном к предательству мире промышленного шпионажа, но они же превратили его в извечного беглеца и лишили всего, что он когда-либо любил."
            )
        )
        filmList.add(
            Films(
                R.drawable.sudia,
                "Судья",
                "Успешный адвокат приезжает в родной город на похороны матери и узнаёт, что его отца, городского судью, подозревают в убийстве. Мужчина решает задержаться, чтобы выяснить правду, и постепенно лучше узнаёт родственников, с которыми давно не общался."
            )
        )
        filmList.add(
            Films(
                R.drawable.onetoone,
                "Один плюс Один",
                "Пострадав в результате несчастного случая, богатый аристократ Филипп нанимает в помощники человека, который менее всего подходит для этой работы, – молодого жителя предместья Дрисса, только что освободившегося из тюрьмы. Несмотря на то, что Филипп прикован к инвалидному креслу, Дриссу удается привнести в размеренную жизнь аристократа дух приключений."
            )
        )



        filmsAdapter = FilmsAdapter(filmList).apply {

            onItemClick = ::onClickOne

        }
        recyclerView.adapter = filmsAdapter




    }

    fun onClickOne(films: Films) {
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra(DetailedActivity.TITLE_KEY, films)
        startActivity(intent)
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены, что хотите выйти из программы?")

            setPositiveButton("Да") { _, _ ->
                super.onBackPressed()
            }

            setNegativeButton("Нет"){_, _ ->
                // if user press no, then return the activity
                Toast.makeText(this@MainActivity, "Thank you",
                    Toast.LENGTH_LONG).show()
            }
            setCancelable(true)
        }.create().show()
    }

}



