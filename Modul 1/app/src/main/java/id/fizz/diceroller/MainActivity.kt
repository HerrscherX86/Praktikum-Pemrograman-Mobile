package id.fizz.diceroller
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage1: ImageView
    private lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage1 = findViewById(R.id.imageView1)
        diceImage2 = findViewById(R.id.imageView2)
        diceImage1.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }
    private fun rollDice() {
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()
        val drawableResource1 = getDrawableResource(diceRoll1)
        val drawableResource2 = getDrawableResource(diceRoll2)
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)
        val message = if (diceRoll1 == diceRoll2) "Selamat anda dapat dadu double!" else "Anda belum beruntung!"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun getDrawableResource(diceRoll: Int): Int {
        return when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}