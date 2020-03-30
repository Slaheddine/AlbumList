package me.slaheddine.leboncoin

import me.slaheddine.leboncoin.data.mapper.AlbumDataMapper
import me.slaheddine.leboncoin.data.network.AlbumsRestApi
import me.slaheddine.leboncoin.data.repository.CloudAlbumRepository
import me.slaheddine.leboncoin.domain.mapper.AlbumMapper
import me.slaheddine.leboncoin.domain.usecases.GetAlbumsUseCase
import me.slaheddine.leboncoin.presentation.viewmodels.AlbumViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    single {
        AlbumsRestApi()
    }

    single {
        AlbumDataMapper()
    }

    single {
        AlbumMapper()
    }

    single {
        CloudAlbumRepository(get(), get())
    }

    single {
        GetAlbumsUseCase(get(), get())
    }

    viewModel { AlbumViewModel(get()) }

}

