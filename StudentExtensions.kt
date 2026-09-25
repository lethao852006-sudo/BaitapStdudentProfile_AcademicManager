package com.example.studentprofilecard

fun Double.toAcademicRanking(): String {
    return when {
        this >= 3.6 -> "Xuất sắc"
        this >= 3.2 -> "Giỏi"
        this >= 2.5 -> "Khá"
        else -> "Trung bình"
    }
}