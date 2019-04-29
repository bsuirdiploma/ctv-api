package by.trusevich.house.ctv.validation

import by.trusevich.house.ctv.repository.CtvRepository
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.annotation.AnnotationTarget.FIELD
import kotlin.annotation.AnnotationTarget.PROPERTY_GETTER
import kotlin.reflect.KClass

/**
 * Validates, that the ctv zone name is unique in database
 */
@Retention
@Target(PROPERTY_GETTER, FIELD)
@MustBeDocumented
@Constraint(validatedBy = [NameUniqueValidator::class])
annotation class NameUnique(
    @Suppress("unused") val message: String = "Ctv with such name already exists",
    @Suppress("unused") val groups: Array<KClass<*>> = [],
    @Suppress("unused") val payload: Array<KClass<out Payload>> = []
)

class NameUniqueValidator(private val ctvRepository: CtvRepository) : ConstraintValidator<NameUnique, String?> {

    override fun initialize(constraint: NameUnique) = Unit

    override fun isValid(name: String?, context: ConstraintValidatorContext) =
        name == null || !ctvRepository.existsByName(name)
}
