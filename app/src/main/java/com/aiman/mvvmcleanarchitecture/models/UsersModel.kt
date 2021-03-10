package com.aiman.mvvmcleanarchitecture.models

import com.google.gson.annotations.SerializedName

data class UsersModel (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("username") val username : String,
    @SerializedName("email") val email : String,
    @SerializedName("address") val address : Address,
    @SerializedName("phone") val phone : String,
    @SerializedName("website") val website : String,
    @SerializedName("company") val company : Company
)

data class Address (
    @SerializedName("street") val street : String,
    @SerializedName("suite") val suite : String,
    @SerializedName("city") val city : String,
    @SerializedName("zipcode") val zipcode : String,
    @SerializedName("geo") val geo : Geo
)

data class Company (
    @SerializedName("name") val name : String,
    @SerializedName("catchPhrase") val catchPhrase : String,
    @SerializedName("bs") val bs : String
)

data class Geo (
    @SerializedName("lat") val lat : Double,
    @SerializedName("lng") val lng : Double
)