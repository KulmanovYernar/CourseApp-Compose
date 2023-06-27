package com.example.courseapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val titleResourceId:Int,
    val studentsCount:Int,
    @DrawableRes val imageResourceId:Int
    )
