package com.example.tv_timedata

data class MoviesTest(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)