package klinka.com.coronavirus.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import klinka.com.coronavirus.R
import klinka.com.coronavirus.model.CoronaModel
import klinka.com.coronavirus.service.GetDataService
import klinka.com.coronavirus.service.RetrofitConfig
import kotlinx.android.synthetic.main.activity_corona.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.NumberFormat

class CoronaActivity : AppCompatActivity() {

    var listCountries: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corona)
        title = getString(R.string.toolbar_title)

        loadData()

        swipeRefresh_layout.setOnRefreshListener {
            loadData()
        }
    }

    private fun loadData() {
        val retrofitClient = RetrofitConfig.dataConfig()

        val endpoint = retrofitClient.create(GetDataService::class.java)
        val callback = endpoint.getAllCountries()

        callback.enqueue(object : Callback<CoronaModel> {
            override fun onFailure(call: Call<CoronaModel>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<CoronaModel>, response: Response<CoronaModel>) {
                response.body()?.let { coronaModel ->
                    onLoadDataComplete(coronaModel)
                }
            }
        })
    }

    private fun onLoadDataComplete(coronaModel: CoronaModel) {
        fillGlobalStatistic(coronaModel)

        coronaModel.countries.forEach { summary ->
            if (!summary.country.isNullOrEmpty()) {
                listCountries.add(summary.country!!)
            }
        }

        swipeRefresh_layout.isRefreshing = false
    }

    private fun fillGlobalStatistic(coronaModel: CoronaModel) {
        var numberFormat: NumberFormat = NumberFormat.getIntegerInstance()

        global_total_confirmed_value_card.text = numberFormat.format(coronaModel.global.confirmed)
        global_total_deaths_value_card.text = numberFormat.format(coronaModel.global.deaths)
        global_total_recovered_value_card.text = numberFormat.format(coronaModel.global.recovered)
    }
}

