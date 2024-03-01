package com.example.sportsbuddy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Firebase 앱 초기화
        FirebaseApp.initializeApp(this)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.home // 두 번째 아이템의 ID를 전달하여 선택되도록 설정

        val profilePhoto = findViewById<ImageView>(R.id.profilePhoto)
        profilePhoto.setOnClickListener {
            // MypageActivity로 이동하는 코드
            val intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance() // Firebase 인증 객체 초기화

        // 로그인 상태를 확인하고 이에 따라 화면을 표시하는 함수 호출
        checkLoginStatus()
    }


    private fun checkLoginStatus() {
        val currentUser = auth.currentUser
        if (currentUser == null) {
            // 로그인되어 있지 않으면 로그인 액티비티로 이동
            goLoginPage()
            finish() // 현재 액티비티 종료
        } else {
            // 로그인되어 있으면 메인 화면을 유지
            // 따로 처리할 것이 없으므로, 아무것도 하지 않습니다.
        }
    }

    private fun goLoginPage() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // 현재 액티비티 종료
    }


}
