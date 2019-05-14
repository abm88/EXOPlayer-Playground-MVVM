package net.playgorund.exoplayerplayground.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class ApiVideo(@SerializedName("public_id") val publicId: String,
                    val version: Long,
                    val format: String,
                    val width: Int,
                    val height: Int,
                    val type: String,
                    @SerializedName("created_at") val createdAt: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(publicId)
        parcel.writeLong(version)
        parcel.writeString(format)
        parcel.writeInt(width)
        parcel.writeInt(height)
        parcel.writeString(type)
        parcel.writeString(createdAt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ApiVideo> {
        override fun createFromParcel(parcel: Parcel): ApiVideo {
            return ApiVideo(parcel)
        }

        override fun newArray(size: Int): Array<ApiVideo?> {
            return arrayOfNulls(size)
        }
    }
}