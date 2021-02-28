package com.example.photographer.di.module

import com.example.photographer.business.datasource.local.UsersLocalDataSource
import com.example.photographer.business.datasource.remote.UsersRemoteDataSource
import com.example.photographer.business.repository.UsersRepository
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(DataSourceModule::class))
class RepositoryModule {

    @Provides
    fun provideUsersRepositoryModule(localDataSource: UsersLocalDataSource, remoteDataSource: UsersRemoteDataSource): UsersRepository {
        return UsersRepository(localDataSource, remoteDataSource)
    }

}