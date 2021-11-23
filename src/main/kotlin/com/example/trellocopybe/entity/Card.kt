package com.example.trellocopybe.entity

import org.hibernate.Hibernate
import javax.persistence.*
import javax.persistence.Column

@Table(name = "cards")
@Entity
class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null

    @Column(nullable = false)
    var name: String? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "column_id")
    var column: com.example.trellocopybe.entity.Column? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Card

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name )"
    }
}