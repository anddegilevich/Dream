package and.degilevich.dream.shared.core.db.impl.database

import androidx.room.RoomDatabaseConstructor

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
internal expect object AppDatabaseConstructor : RoomDatabaseConstructor<AbstractAppDatabase> {
    override fun initialize(): AbstractAppDatabase
}