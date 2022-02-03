package com.example.asstudy

data class ForestPointResponse (
    val data: List<ForestPoint>
) {
    data class ForestPoint (
        val analdate: String,
        val doname: String,
        val regioncode: Int,
        val searchcd: String,
        val std: Int,
        val meanavg: Int,
        val maxi: Int,
        val d1: Int,
        val d2: Int,
        val d3: Int,
        val d4: Int
    )
}
