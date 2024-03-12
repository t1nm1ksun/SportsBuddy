package com.example.sportsbuddy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MypageActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage) //

        auth = FirebaseAuth.getInstance() // Firebase 인증 객체 초기화

        val logout = findViewById<Button>(R.id.logout)
        logout.setOnClickListener {
            auth.signOut()
            Toast.makeText(this, "로그아웃 완료", Toast.LENGTH_SHORT).show()
            goLoginpage()
        }

        val edit = findViewById<Button>(R.id.edit)
        edit.setOnClickListener{
            Toast.makeText(this,"설정 완료",Toast.LENGTH_SHORT).show()
            goMainpage()
        }
    }

    private fun goLoginpage(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // 현재 액티비티를 종료하고 로그인 액티비티로 이동
    }

    private fun goMainpage(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // 현재 액티비티를 종료하고 로그인 액티비티로 이동
    }
}
