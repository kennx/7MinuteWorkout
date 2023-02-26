package cc.niaoer.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
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

        getAllCompletedDates()
    }

    private fun getAllCompletedDates() {
        val dbHandler = SqliteOpenHelper(this, null)
        val allCompletedDatesList = dbHandler.getAllCompletedDateList()

        if (allCompletedDatesList.size > 0) {
            binding.tvHistory.visibility = View.VISIBLE
            binding.rvHistory.visibility = View.VISIBLE
            binding.tvNoDataAvailable.visibility = View.GONE

            binding.rvHistory.layoutManager = LinearLayoutManager(this)
            val historyAdapter = HistoryAdapter(this, allCompletedDatesList)
            binding.rvHistory.adapter = historyAdapter
        } else {
            binding.tvNoDataAvailable.visibility = View.VISIBLE
            binding.tvHistory.visibility = View.GONE
            binding.rvHistory.visibility = View.GONE
        }
    }
}