package com.a_ches.buttoncounterapp.di

import com.a_ches.buttoncounterapp.presenter.ScreenPresenter
import com.a_ches.buttoncounterapp.presenter.repository.RepositoryPresenter
import com.a_ches.buttoncounterapp.presenter.user.UserPresenter
import com.a_ches.buttoncounterapp.presenter.users.UsersPresenter
import com.a_ches.buttoncounterapp.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class,
        RepoModule::class,
        ApiModule::class,
        AppModule::class,
        UiScheduler::class,
        NetworkStatusModule::class,
        CacheModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(screenPresenter: ScreenPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(userPresenter: UserPresenter)
    fun inject(repositoryPresenter: RepositoryPresenter)
}