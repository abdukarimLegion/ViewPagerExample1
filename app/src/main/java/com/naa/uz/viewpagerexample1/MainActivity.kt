package com.naa.uz.viewpagerexample1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.naa.uz.viewpagerexample1.adapder.ViewPagerAdapter
import com.naa.uz.viewpagerexample1.databinding.ActivityMainBinding
import com.naa.uz.viewpagerexample1.model.ModelViewPager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var data: ArrayList<ModelViewPager>
    private lateinit var myAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )


        data = ArrayList()
        data.add(
            ModelViewPager(
                "Xush kelibsiz",
                "Kim ko‘rubdur, ey ko‘ngul, ahli jahondin yaxshilig‘, \n" +
                        "Kimki, ondin yaxshi yo‘q, ko‘z tutma ondin yaxshilig‘",
                R.drawable.rectangle1
            )
        )


        data.add(
            ModelViewPager(
                "Hikoyalar dunyosi",
                "Gar zamonni nayf qilsam ayb qilma, ey rafiq, \n" +
                        "Ko‘rmadim hargiz, netoyin, bu zamondin yaxshilig‘ ! ",
                R.drawable.rectangle2
            )
        )

        data.add(
            ModelViewPager(
                "Kitob ortidan..",
                "Dilrabolardin yomonliq keldi mahzun ko‘ngluma,\n" +
                        " Kelmadi jonimg'a hech oromi jondin yaxshilig'.gh",
                R.drawable.rectangle3
            )
        )

        data.add(
            ModelViewPager(
                "Bizga qo`shiling",
                "Ey ko‘ngul, chun yaxshidin ko‘rdung yamonliq asru ko‘p,\n" +
                        " Emdi ko‘z tutmoq ne ma’ni har yamondin yaxshilig'? ",
                R.drawable.rectangle4
            )
        )

        myAdapter = ViewPagerAdapter(data, supportFragmentManager)
        binding.viewPager.adapter = myAdapter
        binding.tablayout.setupWithViewPager(binding.viewPager)

        binding.skipBtn.setOnClickListener {
           val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }


}