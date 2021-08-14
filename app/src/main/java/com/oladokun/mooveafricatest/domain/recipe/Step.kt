package com.oladokun.mooveafricatest.domain.recipe

data class Step(
    val description: String? = null,
    val id: Int? = 0,
    val shortDescription: String? = null,
    val thumbnailURL: String? = null,
    val videoURL: String? = null
)