package me.slaheddine.leboncoin

import me.slaheddine.data.network.AlbumsRestApi
import me.slaheddine.data.repository.CloudAlbumRepository
import me.slaheddine.data.mapper.AlbumDataMapper
import me.slaheddine.domain.repository.AlbumsRepository
import me.slaheddine.domain.usecases.GetAlbumsUseCase
import me.slaheddine.leboncoin.presentation.mapper.AlbumMapper
import me.slaheddine.leboncoin.presentation.viewmodels.AlbumViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    single {
        AlbumsRestApi(get(), BuildConfig.BASE_URL)
    }

    single {
        AlbumDataMapper()
    }

    single {
        AlbumMapper()
    }

    single {
        CloudAlbumRepository(get(), get()) as AlbumsRepository
    }

    single {
        GetAlbumsUseCase(get())
    }

    viewModel {
        AlbumViewModel(get(), get())
    }

}

