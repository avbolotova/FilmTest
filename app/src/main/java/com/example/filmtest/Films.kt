package com.example.filmtest

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Films(val image: Int, val name: String, val description: String) : Serializable {

}
