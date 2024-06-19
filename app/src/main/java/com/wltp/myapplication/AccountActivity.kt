package com.wltp.myapplication

import RSPmodel
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wltp.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import android.view.View
import com.wltp.myapplication.databinding.ActivityAccountBinding

class AccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountBinding
    private val rsPmodel = RSPmodel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        val view  = binding.root
        setContentView(view)
        binding.showResult.visibility = View.INVISIBLE
        binding.exit.visibility = View.INVISIBLE

        binding.rock.setOnClickListener {
            binding.textView.setText("당신의 선택 : 주먹")
            rsPmodel.setUserRSP("ROCK")
            binding.showResult.visibility = View.VISIBLE
            binding.exit.visibility = View.VISIBLE
            buttons_visibility()
        }
        binding.scissors.setOnClickListener {
            binding.textView.setText("당신의 선택 : 가위")
            rsPmodel.setUserRSP("SCISSORS")
            binding.showResult.visibility = View.VISIBLE
            binding.exit.visibility = View.VISIBLE
            buttons_visibility()
        }
        binding.paper.setOnClickListener {
            binding.textView.setText("당신의 선택 : 보자기")
            rsPmodel.setUserRSP("PAPER")
            binding.showResult.visibility = View.VISIBLE
            binding.exit.visibility = View.VISIBLE
            buttons_visibility()
        }
        binding.showResult.setOnClickListener {
            rsPmodel.saveResult()
            val result = rsPmodel.getResult()
            var text = "로봇이 낸 것 : " + result.first.toString() + "\n당신이 낸 것 : " + result.second.toString() + "\n결과 : " + result.third.toString()
            binding.textView.setText(text)
            binding.showResult.visibility = View.GONE
            binding.exit.visibility = View.VISIBLE
        }
        binding.exit.setOnClickListener {
            binding.textView.setText("선택하시오")
            binding.rock.visibility = View.VISIBLE
            binding.scissors.visibility = View.VISIBLE
            binding.paper.visibility = View.VISIBLE
            binding.showResult.visibility = View.GONE
            binding.exit.visibility = View.GONE
        }
    }

    fun buttons_visibility() {

        binding.rock.visibility = View.GONE
        binding.scissors.visibility = View.GONE
        binding.paper.visibility = View.GONE
    }
}