package com.scorradi.cv.datamanager.person

import com.google.gson.annotations.SerializedName

class SocialNetworkLink (
    var name: String,
    @SerializedName("link")
    var url: String
)