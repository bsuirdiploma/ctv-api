package by.trusevich.house.ctv.model

import by.trusevich.house.core.model.BaseEntity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY
import org.hibernate.envers.Audited
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.URL
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint
import javax.validation.constraints.NotBlank

@Entity
@Audited
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(uniqueConstraints = [UniqueConstraint(name = "unique_name", columnNames = ["name"])])
data class Ctv(

    @get:NotBlank
    @get:Length(max = 255)
    @Column(nullable = false, updatable = false)
    var name: String? = null,

    @get:NotBlank
    @get:Length(max = 255)
    @Column(nullable = false, updatable = false)
    var location: String? = null,

    @get:NotBlank
    @get:URL
    @get:Length(max = 255)
    @Column(nullable = false, updatable = false)
    var videoUrl: String? = null

) : BaseEntity() {

    companion object {

        private const val serialVersionUID = 79835162396908742L
    }
}
