---
name: db-module-rules
description: core/db module conventions — Room entities, DAOs, cross-refs, relations, AppDatabase. Use when creating or modifying a Room Entity, Dao, cross-ref, relation, or the AppDatabase in shared/core/db.
---

# DB Rules

* `core/db/api` exposes: `Entity` classes, `@Dao` interfaces, cross-ref entities, relation ("extended") data classes, and the `AppDatabase` interface — all public, no impl
* `core/db/impl` provides: `AbstractAppDatabase` (`internal abstract class : RoomDatabase(), AppDatabase`), the `AppDatabaseFactory`, platform builder (`AppDatabaseBuilderFactoryImpl.android.kt`/`.ios.kt`), and `dbModule()` — the only impl surface, Room codegens the rest via KSP
* Entity: `@Entity(tableName = <X>Entity.TABLE_NAME) data class <X>Entity(@PrimaryKey @ColumnInfo(name = ID) val id: String, ...)`; every column name is a `const val` in an `internal companion object` (`TABLE_NAME`, `ID`, `<COLUMN>`) — never an inline string literal repeated at call sites
* Non-key columns are typically nullable (`val name: String? = null`) since Room entities mirror partially-known cached data, unlike domain models which are non-null
* Dao: `@Dao interface <X>Dao` with `@Upsert suspend fun upsert(entity: <X>Entity)` + `@Upsert suspend fun upsertAll(entities: List<<X>Entity>)` as the baseline read/write pair; add query methods as needed
* Many-to-many links get a dedicated cross-ref entity: `<A>To<B>CrossRefEntity` with composite `primaryKeys` of both FK columns and `ForeignKey(..., onDelete = ForeignKey.CASCADE)` on both sides, plus its own `<X>Dao`
* Joined reads use a `<X>ExtendedEntity` relation data class: `@Embedded val x: XEntity` plus `@Relation(entity = ..., parentColumn = ..., entityColumn = ..., associateBy = Junction(...))` for many-to-many, or a plain `@Relation` for a direct FK (e.g. tracks belonging to an album)
* `AppDatabase` interface declares one `fun get<X>Dao(): <X>Dao` per entity/cross-ref; `AbstractAppDatabase`'s `@Database(entities = [...])` list must include every `Entity`/cross-ref-`Entity` class or Room fails to compile
* `dbModule()` (`core/db/impl/di`) wires `AppDatabaseFactory` and calls `.create()` once behind a Koin `single { }` bound to `AppDatabase::class`
* Local data sources (feature `data/impl`) depend on `AppDatabase` (via `BaseLocalDataSource`), never on `AbstractAppDatabase` or a concrete Dao impl directly — see `data-module-rules`
