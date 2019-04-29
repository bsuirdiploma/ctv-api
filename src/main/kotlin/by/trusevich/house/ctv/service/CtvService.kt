package by.trusevich.house.ctv.service

import by.trusevich.house.core.service.AbstractCrudService
import by.trusevich.house.ctv.model.Ctv
import by.trusevich.house.ctv.repository.CtvRepository
import org.springframework.stereotype.Service

@Service
class CtvService(ctvRepository: CtvRepository) : AbstractCrudService<Ctv>(ctvRepository)
