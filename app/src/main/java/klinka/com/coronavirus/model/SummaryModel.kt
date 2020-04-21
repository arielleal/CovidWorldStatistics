package klinka.com.coronavirus.model

import com.google.gson.annotations.SerializedName

data class SummaryModel (
    @SerializedName("Country")
    var country: String?,
    @SerializedName("TotalConfirmed")
    var confirmed: String,
    @SerializedName("TotalDeaths")
    var deaths: String,
    @SerializedName("TotalRecovered")
    var recovered: String,
    @SerializedName("Date")
    var update: String?
)