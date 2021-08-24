package com.example.messageapp.Di

import com.example.messageapp.mvvm.chat.ViewModelChat
import com.example.messageapp.mvvm.chatContact.ModelContacts
import com.example.messageapp.mvvm.chatContact.ViewModelContacts
import com.example.messageapp.mvvm.choiseCategory.ModelChoiseCategory
import com.example.messageapp.mvvm.choiseCategory.ViewModelChoiseCategory
import com.example.messageapp.mvvm.choiseCity.ModelChoiseCity
import com.example.messageapp.mvvm.choiseCity.ViewModelChoiseCity
import com.example.messageapp.mvvm.choiseUser.ModelChoiseUser
import com.example.messageapp.mvvm.choiseUser.ViewModelChoiseUser
import com.example.messageapp.mvvm.completionOfRegistration.ModelCompleteOfRegistration
import com.example.messageapp.mvvm.completionOfRegistration.ViewModelCompleteOfRegistration
import com.example.messageapp.mvvm.createRequest.ModelCreateRequest
import com.example.messageapp.mvvm.createRequest.ViewModelCreateRequest
import com.example.messageapp.mvvm.customerSetting.ModelCustomerSetting
import com.example.messageapp.mvvm.customerSetting.ViewModelCustomerSetting
import com.example.messageapp.mvvm.loginPassword.ModelLoginPassword
import com.example.messageapp.mvvm.loginPassword.ViewModelLoginPassword
import com.example.messageapp.mvvm.notificationForSupplier.ModelNotificationForSupplier
import com.example.messageapp.mvvm.notificationForSupplier.ViewModelNotificationForSupplier
import com.example.messageapp.mvvm.succesfullRegistration.ViewModelSuccesfullRegistration
import com.example.messageapp.mvvm.buttonNavigation.ViewModelNavigationMenu
import org.koin.dsl.module


val ChoiseUserModule = module {
    factory { ViewModelChoiseUser(get()) }
    factory { ModelChoiseUser() }
}

val loginPasswordModule = module {
    factory { ViewModelLoginPassword(get()) }
    factory { ModelLoginPassword() }
}

val choiseCategoryModule = module {
    factory { ViewModelChoiseCategory(get()) }
    factory { ModelChoiseCategory() }
}

val choiseCityModule = module {
    factory { ViewModelChoiseCity(get()) }
    factory { ModelChoiseCity() }
}
val ButtonNavigationModule = module {
    factory { ViewModelNavigationMenu() }

}

val viewChatModule = module {
    factory { ViewModelChat(get()) }
    factory { ModelChoiseCategory() }
}

val createRequestModule = module {
    factory { ViewModelCreateRequest(get()) }
    factory { ModelCreateRequest() }
}

val notificationForSupplierModule = module {
    factory { ViewModelNotificationForSupplier(get()) }
    factory { ModelNotificationForSupplier() }
}

val succesfullRegistrationModule = module {
    factory { ViewModelSuccesfullRegistration() }
}

val customerSettingModule = module {
    factory { ViewModelCustomerSetting(get()) }
    factory { ModelCustomerSetting() }
}

val completionOfRegistrationModule = module {
    factory { ViewModelCompleteOfRegistration(get()) }
    factory { ModelCompleteOfRegistration() }
}

val contactsModule = module {
    factory { ViewModelContacts(get()) }
    factory { ModelContacts() }
}