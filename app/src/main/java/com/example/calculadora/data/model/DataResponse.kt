package com.example.calculadora.data.model

import android.adservices.common.AdData
import com.google.gson.annotations.SerializedName

data class DataResponse (
    @SerializedName("data") val data: UserModel?,
    @SerializedName("message") val message: String?,
    @SerializedName("status") val status: String?,

    )