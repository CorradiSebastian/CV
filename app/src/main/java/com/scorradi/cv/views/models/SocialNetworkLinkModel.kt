package com.scorradi.cv.views.models

import com.scorradi.cv.datamanager.person.SocialNetworkLink

class SocialNetworkLinkModel(socialNetworkLink: SocialNetworkLink){
    val name = socialNetworkLink.name
    val link = socialNetworkLink.url
}