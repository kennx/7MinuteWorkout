package cc.niaoer.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cc.niaoer.a7minuteworkout.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarHistoryActivity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "HISTORY"

        binding.toolbarHistoryActivity.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}