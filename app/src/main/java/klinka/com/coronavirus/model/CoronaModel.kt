package klinka.com.coronavirus.model

import com.google.gson.annotations.SerializedName

data class CoronaModel (
    @SerializedName("Global")
    var global: SummaryModel,
    @SerializedName("Countries")
    var countries: List<SummaryModel>
)