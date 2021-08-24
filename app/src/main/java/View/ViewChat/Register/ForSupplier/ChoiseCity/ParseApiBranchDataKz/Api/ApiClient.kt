package View.ViewChat.Register.ForSupplier.ChoiseCity.ParseApiBranchDataKz.Api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {

    @GET("/David-Haim/CountriesToCitiesJSON/master/countriesToCities.json")
    fun upCommingEventData(): Call<ResponseBody>
}