package br.com.ferreira.calculadoraflex.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ferreira.calculadoraflex.R
import br.com.ferreira.calculadoraflex.ui.extensions.format
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        setContentView(R.layout.activity_result)
        if (intent.extras == null) {
            Toast.makeText(this, "Não foi possível realizar a operação",
                Toast.LENGTH_SHORT).show()
        } else {
            calculate()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun calculate() {
        val gasPrice = intent.extras!!.getDouble("GAS_PRICE", 0.0)
        val ethanolPrice = intent.extras!!.getDouble("ETHANOL_PRICE", 0.0)
        val gasAverage = intent.extras!!.getDouble("GAS_AVERAGE", 0.0)
        val ethanolAverage = intent.extras!!.getDouble("ETHANOL_AVERAGE", 0.0)

        val performanceOfMyCar = ethanolAverage / gasAverage
        val priceOfFuelIndice = ethanolPrice / gasPrice

        tvEthanolAverageResult.text = (ethanolPrice / ethanolAverage).format(2)
        tvGasAverageResult.text = (gasPrice / ethanolAverage).format(2)
        tvFuelRatio.text = getString(R.string.label_fuel_ratio,performanceOfMyCar.format(2))


        if (priceOfFuelIndice <= performanceOfMyCar) {
            tvSuggestion.text = getString(R.string.ethanol)
        } else {
            tvSuggestion.text = getString(R.string.gasoline)
        }

    }
}
