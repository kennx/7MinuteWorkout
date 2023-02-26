package cc.niaoer.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cc.niaoer.a7minuteworkout.databinding.ActivityFinishBinding
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFinishBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarFinishActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbarFinishActivity.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnFinish.setOnClickListener {
            finish()
        }

        addDateToDatabase()
    }

    private fun addDateToDatabase() {
        val calendar = Calendar.getInstance()
        val dateTime = calendar.time
        Log.i("DATE: ", dateTime.toString())

        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())
        val date = sdf.format(dateTime)

        val dbHandler = SqliteOpenHelper(this, null)
        dbHandler.addDate(date)
        Log.i("DATE: ", "Added")

    }
}