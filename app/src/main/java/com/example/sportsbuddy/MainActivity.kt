package com.example.sportsbuddy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setSelectedItemId(R.id.home) // 두 번째 아이템의 ID를 전달하여 선택되도록 설정

        val profilePhoto = findViewById<ImageView>(R.id.profilePhoto)
        profilePhoto.setOnClickListener {
            // MypageActivity로 이동하는 코드
            val intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
        }
    }
}
