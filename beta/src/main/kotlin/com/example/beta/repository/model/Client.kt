package com.example.beta.repository.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Represents the database entity for storing the clients details.
 */
@Entity
@Table(name = "client")
data class Client (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "phone", nullable = false)
    val phone: String,
    @Column(name = "email_address", nullable = false)
    val email: String,
    @Column(name = "address", nullable = false)
    val address: String,
    @Column(name = "commentOrPromocode", nullable = true)
    val commentOrPromocode: String?
)
