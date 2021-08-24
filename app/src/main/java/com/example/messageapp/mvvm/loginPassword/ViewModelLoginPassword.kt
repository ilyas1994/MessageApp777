package com.example.messageapp.mvvm.loginPassword

import androidx.databinding.BaseObservable
import com.example.messageapp.AndroidInstrument.SinglInstrument
import com.example.messageapp.Singleton.SingletonMain
import com.example.messageapp.mvvm.choiseCategory.ViewChoiseCategory

class ViewModelLoginPassword(model: ModelLoginPassword): BaseObservable() {

//    private var checkEdits = mutableListOf<EditText>()


    var editPhone = ""
    var editPassword = ""

    fun button_Save(){
       SinglInstrument.switchFragment(ViewChoiseCategory())
    }

// позже посмотреть!!
//    private fun checkEditsText() {
//        for (i in 0..checkEdits.count() - 1) {
//            if (checkEdits[i].text.isNotEmpty()) {
//                checkEdits[i].background = ResourcesCompat.getDrawable(
//                    requireActivity().resources,
//                    R.drawable.register_for_supplier_design_true_filed,
//                    null
//                )
//
//            } else {
//                checkEdits[i].background = ResourcesCompat.getDrawable(
//                    requireActivity().resources,
//                    R.drawable.register_for_supplier_design_false_filed,
//                    null
//                )
//                Toast.makeText(context, "Заполните красные поля", Toast.LENGTH_SHORT).show()
//            }
//        }
//        for (j in 0..checkEdits.count() - 1) {
//            if (checkEdits[0].text.isNotEmpty() && checkEdits[1].text.isNotEmpty()) {
//                SinglInstrument.switchFragment(ViewFragmentChoiseCategory())
//            }
//        }
//    }
}