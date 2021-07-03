package com.scorradi.cv.datamanager.service.person

import com.google.gson.annotations.SerializedName

class SocialNetworkLinkDTO (
    var name: String,
    @SerializedName("link")
    var url: String
    )
