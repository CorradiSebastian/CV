package com.scorradi.cv.service.person

import kotlin.collections.ArrayList

class PersonDTO(var name:String,
                var id:String,
                var bornDate: Long,
                var phoneNumber:String,
                var networkLinks: ArrayList<SocialNetworkLinkDTO>){

}