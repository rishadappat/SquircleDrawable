package ru.rosystem.example

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.rosystem.squircledrawable.SquircleDrawable

class MainActivity : AppCompatActivity() {
    private val imageUrl = "https://cdn.pixabay.com/photo/2015/07/30/11/04/bike-867229_960_720.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.image_view)
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            val bitmap = Picasso.get().load(imageUrl).get()
            val drawable = SquircleDrawable(bitmap)
            withContext(Dispatchers.Main) {
                imageView.setImageDrawable(drawable)
            }
        }
    }
}