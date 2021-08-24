package View.ViewChat.Register.ForSupplier.ChoiseCity.ParseApiBranchDataKz.Api

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class ApiRetrofit {

    val apiRetroft: Retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    val apiClient: ApiClient = apiRetroft.create(ApiClient::class.java)
}