package com.educode.examentottus.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.educode.examentottus.data.repository.MemberRepository
import com.educode.examentottus.data.repository.TeamRepository
import com.educode.examentottus.data.repository.UserRepository
import com.educode.examentottus.data.source.LocalDataSource
import com.educode.examentottus.data.source.TottusDatabase
import com.educode.examentottus.data.source.TottusDbDataSource
import com.educode.examentottus.domain.usecases.*
import com.educode.examentottus.presentation.ui.home.ui.home.HomeFragment
import com.educode.examentottus.presentation.ui.home.ui.home.HomeViewModel
import com.educode.examentottus.presentation.ui.home.ui.team.*
import com.educode.examentottus.presentation.ui.home.ui.team.dialog.DialogFragment
import com.educode.examentottus.presentation.ui.home.ui.team.dialog.DialogViewModel
import com.educode.examentottus.presentation.ui.home.ui.team.member.MemberFragment
import com.educode.examentottus.presentation.ui.home.ui.team.member.MemberViewModel
import com.educode.examentottus.presentation.ui.home.ui.team.team.TeamFragment
import com.educode.examentottus.presentation.ui.home.ui.team.team.TeamViewModel
import com.educode.examentottus.presentation.ui.login.LoginActivity
import com.educode.examentottus.presentation.ui.login.LoginViewModel
import com.educode.examentottus.presentation.ui.register.RegisterActivity
import com.educode.examentottus.presentation.ui.register.RegisterViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

private val appModule = module {
    single { TottusDatabase.build(get()) }
    single { provideSettingsPreferences(androidApplication()) }
    factory<LocalDataSource> { TottusDbDataSource(get()) }
}

private const val PREFERENCES_FILE_KEY = "tottus_prefs"

private fun provideSettingsPreferences(app: Application): SharedPreferences =
    app.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE)

private val dataModule = module {
    factory { UserRepository(get() ) }
    factory { TeamRepository(get()) }
    factory { MemberRepository(get()) }
}

private val scopesModule = module {
    scope(named<LoginActivity>()) {
        viewModel { LoginViewModel(get(),get()) }
        scoped { Autenticate(get()) }
    }

    scope(named<RegisterActivity>()) {
        viewModel { RegisterViewModel(get()) }
        scoped { InsertUser(get()) }
    }

    scope(named<HomeFragment>()) {
        viewModel { HomeViewModel(get()) }
        //viewModel { TeamViewModel() }
        //scoped { InsertUser(get()) }
    }
    scope(named<TeamFragment>()) {
        viewModel { TeamViewModel(get(),get()) }
        scoped { GetTeam(get()) }
    }
    scope(named<DialogFragment>()) {
        viewModel { DialogViewModel(get(),get()) }
        scoped { InsertTeam(get()) }
    }
    scope(named<MemberFragment>()) {
        viewModel { MemberViewModel(get(),get()) }
        scoped { InsertMember(get()) }
        scoped { GetMember(get()) }
    }
}