import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.Sale
import com.example.myapplication.SaleAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val salesList = generateSalesList() // Генерируем список продаж
        val adapter = SaleAdapter(salesList) // Создаем адаптер для списка

        recyclerView.adapter = adapter // Устанавливаем адаптер в RecyclerView

        // Задача: Определить количество товаров, проданных продавцом «Иванов», и товар с максимальной стоимостью
        var ivanovItemsSold = 0
        var maxPriceSale: Sale? = null
        var maxPrice = Double.MIN_VALUE

        for (sale in salesList) {
            if (sale.seller == "Иванов") {
                ivanovItemsSold += sale.quantity
            }
            if (sale.price > maxPrice) {
                maxPrice = sale.price
                maxPriceSale = sale
            }
        }

        println("Количество товаров, проданных продавцом Иванов: $ivanovItemsSold")
        println("Товар с максимальной стоимостью: ${maxPriceSale?.itemName}")
    }

    private fun generateSalesList(): List<Sale> {
        return listOf(
            Sale("Иванов", "Товар1", 10, 100.0, "2024-06-01"),
            Sale("Петров", "Товар2", 5, 200.0, "2024-06-02"),
            Sale("Иванов", "Товар3", 8, 150.0, "2024-06-03")
        )
    }
}