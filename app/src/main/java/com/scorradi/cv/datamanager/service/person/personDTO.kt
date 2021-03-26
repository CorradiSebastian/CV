package com.scorradi.cv.datamanager.service.person

import java.util.*
import kotlin.collections.ArrayList

class PersonDTO(var name:String,
                var id:String,
                var bornDate: Long,
                var phoneNumber:String,
                var networkLinks: ArrayList<SocialNetworkLinkDTO>){

}