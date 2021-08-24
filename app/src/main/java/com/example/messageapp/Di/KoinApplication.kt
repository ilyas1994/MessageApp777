package com.example.messageapp.Di

import android.app.Application
import org.koin.core.context.startKoin

class KoinApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(
                ChoiseUserModule,
                loginPasswordModule,
                choiseCategoryModule,
                choiseCityModule,
                ButtonNavigationModule,
                viewChatModule,
                createRequestModule,
                notificationForSupplierModule,
                succesfullRegistrationModule,
                customerSettingModule,
                completionOfRegistrationModule,
                contactsModule
            ))
        }
    }
}