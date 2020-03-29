package me.slaheddine.leboncoin

import me.slaheddine.leboncoin.presentation.viewmodels.AlbumViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    viewModel { AlbumViewModel() }

}

