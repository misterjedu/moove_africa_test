package com.oladokun.mooveafricatest.domain.recipe

data class Step(
    val description: String,
    val id: Int,
    val shortDescription: String,
    val thumbnailURL: String,
    val videoURL: String
)