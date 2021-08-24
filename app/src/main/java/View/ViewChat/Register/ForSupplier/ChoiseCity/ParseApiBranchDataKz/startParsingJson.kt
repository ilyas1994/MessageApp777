package View.ViewChat.Register.ForSupplier.ChoiseCity.ParseApiBranchDataKz

import View.ViewChat.Register.ForSupplier.ChoiseCity.ParseApiBranchDataKz.Api.ApiRetrofit
import View.ViewChat.Register.ForSupplier.ChoiseCity.ParseApiBranchDataKz.ApiBranchDataKazakhstan.ApiBranchDataKz
import View.ViewChat.Register.ForSupplier.ChoiseCity.ParseApiBranchDataKz.ApiBranchDataKazakhstan.CityOfKZT
import android.widget.TextView
import com.example.messageapp.AndroidInstrument.SinglInstrument
import com.example.messageapp.Singleton.SingletonMain
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class startParsingJson {
// url current pars kz https://raw.githubusercontent.com/David-Haim/CountriesToCitiesJSON/master/countriesToCities.json
    fun parseBranch(){
        ApiRetrofit().apiClient.upCommingEventData().enqueue(object: Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val body = response.body()!!
                    val responseJsonString = body.string()
                    val parseJsonObjectToString = JSONObject(responseJsonString)
                    var rasparseJsonObjectDataKz =
                        parseJsonArraytoJsonObject(parseJsonObjectToString)
                } else SinglInstrument.showInstrument.toast("Проверьте связь с интернетом")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                SinglInstrument.showInstrument.toast(t.localizedMessage)
            }

        })

    }
    fun parseJsonArraytoJsonObject(jsonObject: JSONObject): ApiBranchDataKz{
        SingletonMain.mutlistParse
        var parseJsonKazakhstan = jsonObject.getJSONArray("Kazakhstan")
        println("------" + parseJsonKazakhstan.length())
        for (i in 0..parseJsonKazakhstan.length() - 1){
            SingletonMain.mutlistParse.add(parseJsonKazakhstan[i].toString())
            println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" + parseJsonKazakhstan[i].toString())
        }
        return ApiBranchDataKz(
            Kazakhstan = SingletonMain.mutlistParse
        )
    }
}