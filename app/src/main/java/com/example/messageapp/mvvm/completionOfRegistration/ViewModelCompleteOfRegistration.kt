package com.example.messageapp.mvvm.completionOfRegistration

import android.widget.EditText
import androidx.databinding.BaseObservable

class ViewModelCompleteOfRegistration(model: ModelCompleteOfRegistration): BaseObservable() {

    private var checkEdits2 = mutableListOf<EditText>()

    var Adress = ""
        set(value) { field = value }
        get(){return field}

    var phoneNum = ""
      set(value) { field = value }
      get(){return field}

    fun save(){

    }

    private fun funCheckEditsText2() {
//        for (i in 0..checkEdits2.count() - 1) {
//            if (checkEdits2[i].text.isNotEmpty()) {
////                checkEdits2[i].background = ResourcesCompat.getDrawable(
////                    requireActivity().resources,
////                    R.drawable.register_for_supplier_design_true_filed,
////                    null
////                )
//
//            } else {
//                checkEdits2[i].background = ResourcesCompat.getDrawable(
//                    requireActivity().resources,
//                    R.drawable.register_for_supplier_design_false_filed,
//                    null
//                )
//                Toast.makeText(context, "Заполните красные поля", Toast.LENGTH_SHORT).show()
//            }
//        }
//        for (j in 0..checkEdits2.count() - 1) {
//            if (checkEdits2[0].text.isNotEmpty() && checkEdits2[1].text.isNotEmpty()) {
//                val nextFragment = Router().nextFragment(ViewSuccesfullRegistration())
//                requireActivity().supportFragmentManager.beginTransaction().apply {
//                    replace(R.id.emptyFragment, nextFragment)
//                    commit()
//                }
//            }
//        }
    }
}