
package net.playgorund.exoplayerplayground.data.model


import com.google.gson.annotations.SerializedName
import net.playgorund.exoplayerplayground.data.model.ApiVideo

data class ApiResponse(val resources: List<ApiVideo>,
                       @SerializedName("updated_at") val updatedAt: String)
