package com.a_ches.buttoncounterapp.model.githubusers

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize


@Parcelize
class GithubRepository(
@Expose
val id: String?,
@Expose
val name: String?,
@Expose
val fullName: String?,
@Expose
val language: String?,
@Expose
val forksCount: Int?,
@Expose
val htmlUrl: String?
) : Parcelable