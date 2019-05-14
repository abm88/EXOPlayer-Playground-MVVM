

package net.playgorund.exoplayerplayground.data.source.service

import io.reactivex.Observable
import net.playgorund.exoplayerplayground.data.model.ApiResponse
import retrofit2.http.GET

interface CloudinaryApi {

  @GET("demo/video/list/samples.json")
  fun fetchVideos(): Observable<ApiResponse>
}