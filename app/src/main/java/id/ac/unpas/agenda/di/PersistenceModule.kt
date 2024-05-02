package id.ac.unpas.agenda.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.ac.unpas.agenda.persistences.AppDatabase
import javax.inject.Singleton
import android.app.Application
import androidx.room.Room
import id.ac.unpas.agenda.persistences.TodoDao


@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application) : AppDatabase{
        return Room.databaseBuilder(application, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(appDatabase: AppDatabase) : TodoDao {
        return appDatabase.todoDao()
    }
}