package com.hfad.mentalhealth.model

import java.math.BigDecimal

data class UserData(
    val success: Boolean,
    val time: String,
    val message: String,
    val total_users: Int,
    val offset: Int,
    val limit: Int,
    val users: List<Names>
)

data class Names (
    val last_name: String,
    val email: String,
    val id: Int,
    val phone: String,
    val street: String,
    val state: String,
    val zipcode: String,
    val latitude: BigDecimal,
    val gender: String,
    val first_name: String,
    val date_of_birth: String,
    val job: String,
    val city: String,
    val country: String,
    val longitude: BigDecimal
)