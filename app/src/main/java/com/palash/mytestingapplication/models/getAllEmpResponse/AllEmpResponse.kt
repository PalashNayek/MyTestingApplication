package com.palash.mytestingapplication.models.getAllEmpResponse

data class AllEmpResponse(
    val `data`: List<Data>,
    val message: String,
    val status: String
)