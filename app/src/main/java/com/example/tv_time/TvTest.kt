package com.example.tv_time

data class TvTest(
    val page: Int,
    val results: List<ResultTv>,
    val total_pages: Int,
    val total_results: Int
)