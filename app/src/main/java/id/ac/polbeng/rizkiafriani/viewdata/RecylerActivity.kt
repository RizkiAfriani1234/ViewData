package id.ac.polbeng.rizkiafriani.viewdata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecylerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recyler)

        // Find the RecyclerView from the layout
        val recyclerView = findViewById<RecyclerView>(R.id.recylerView)

        // Handle system bar insets to adjust padding
        ViewCompat.setOnApplyWindowInsetsListener(recyclerView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize data for the adapter
        val dataBuah = listOf("Alpukat", "Durian", "Jamnbu Air", "Manggis", "Strawberry") // Example fruit names
        val dataGambar = listOf(R.drawable.alpukat, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry) // Example image resources

        // Create and set the adapter
        val adapter = BuahAdapter(this, dataBuah, dataGambar)
        recyclerView.adapter = adapter

        // Set the layout manager
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }
}
