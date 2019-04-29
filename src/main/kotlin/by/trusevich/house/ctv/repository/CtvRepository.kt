package by.trusevich.house.ctv.repository

import by.trusevich.house.ctv.model.Ctv
import by.trusevich.house.core.repository.BaseRepository

interface CtvRepository : BaseRepository<Ctv> {

    fun existsByName(name: String): Boolean
}
