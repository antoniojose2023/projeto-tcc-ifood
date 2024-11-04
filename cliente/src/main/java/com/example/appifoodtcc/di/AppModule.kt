package com.example.appifoodtcc.di

import com.example.appifoodtcc.domain.repository.IRepositoryAutenticacao
import com.example.appifoodtcc.domain.repository.RepositoryAutenticacaoImpl
import com.example.appifoodtcc.domain.usecase.UseCaseAutenticacao
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providerFirebaseAuth(): FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun providerRepositoryAutenticacao(firebaseAuth: FirebaseAuth): IRepositoryAutenticacao{
        return RepositoryAutenticacaoImpl(firebaseAuth)
    }

    @Provides
    fun providesUseCaseAutenticacao(): UseCaseAutenticacao{
           return UseCaseAutenticacao()
    }

}