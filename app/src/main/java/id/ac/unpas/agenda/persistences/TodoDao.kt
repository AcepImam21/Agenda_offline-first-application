package id.ac.unpas.agenda.persistences

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import id.ac.unpas.agenda.models.Todo
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Delete

@Dao
interface TodoDao {

    @Query("select * from todo")
    fun loadAll(): LiveData<List<Todo>>

    @Query("select * from todo")
    suspend fun findAll(): List<Todo>

    @Query("select * from todo where id = :id")
    fun load(id: String): LiveData<Todo>

    @Query("select * from todo where id = :id")
    suspend fun getById(id: String): Todo?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(vararg items: Todo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(list: List<Todo>)

    @Query("delete from todo where id = :id")
    suspend fun delete(id: String)

    @Delete
    suspend fun delete(item: Todo)
}