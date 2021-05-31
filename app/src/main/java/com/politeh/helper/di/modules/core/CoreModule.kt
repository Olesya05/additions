package com.politeh.helper.di.modules.core

import android.content.Context
import com.politeh.helper.di.subcomponents.SubcomponentsModule
import com.politeh.helper.ui.utils.DateTimeStringFormatter
import com.politeh.helper.ui.utils.StringProvider
import dagger.Module
import dagger.Provides

@Module(includes = [
    SubcomponentsModule::class
])
object CoreModule {


    @Provides
    fun provideDateTimeStringFormatter(): DateTimeStringFormatter {
        return DateTimeStringFormatter()
    }


    @Provides
    fun provideStringProvider(context: Context): StringProvider {
        return StringProvider(context)
    }


}