package ca.qc.cgodin.labo4recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cgodin.labo4recyclerview.adapter.ItemAdapter
import ca.qc.cgodin.labo4recyclerview.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myDataset = DataSource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.rvAffirmations)
        recyclerView.adapter = ItemAdapter(this, myDataset)

    }
}