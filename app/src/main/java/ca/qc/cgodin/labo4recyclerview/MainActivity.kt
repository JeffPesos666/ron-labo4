package ca.qc.cgodin.labo4recyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cgodin.labo4recyclerview.adapter.ItemAdapter
import ca.qc.cgodin.labo4recyclerview.data.DataSource
import ca.qc.cgodin.labo4recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var  binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myDataset = DataSource().loadAffirmations()
        binding.rvAffirmations.adapter = ItemAdapter(this, myDataset)


        setSupportActionBar(binding.toolbar)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.linearItem -> {
                layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvAffirmations.layoutManager = layoutManager
                true
            }
            R.id.gridItem -> {
                layoutManager = GridLayoutManager(this@MainActivity, 2)
                binding.rvAffirmations.layoutManager = layoutManager
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}