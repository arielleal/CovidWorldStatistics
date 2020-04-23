package klinka.com.coronavirus.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class SummaryModel (
    @SerializedName("Country")
    var country: String?,
    @SerializedName("TotalConfirmed")
    var confirmed: Long,
    @SerializedName("TotalDeaths")
    var deaths: Long,
    @SerializedName("TotalRecovered")
    var recovered: Long,
    @SerializedName("Date")
    var update: Date?
)