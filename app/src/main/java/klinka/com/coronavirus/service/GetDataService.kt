package klinka.com.coronavirus.service

import klinka.com.coronavirus.model.CoronaModel
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {

    @GET("/summary")
    fun getAllCountries(): Call<CoronaModel>
}