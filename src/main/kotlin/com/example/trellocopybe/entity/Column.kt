package com.example.trellocopybe.entity

import org.hibernate.Hibernate
import javax.persistence.*
import javax.persistence.Column

@Table(name = "columns")
@Entity
class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null

    @Column(nullable = false)
    var name: String? = null

    @OrderBy("id")
    @OneToMany(mappedBy = "column", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    var cards: List<Card>? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as com.example.trellocopybe.entity.Column

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name )"
    }


}