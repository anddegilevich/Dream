package and.degilevich.dream.shared.core.db.impl.database

import androidx.room.RoomDatabaseConstructor

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
internal expect object DreamDatabaseConstructor : RoomDatabaseConstructor<DreamDatabaseAbs> {
    override fun initialize(): DreamDatabaseAbs
}