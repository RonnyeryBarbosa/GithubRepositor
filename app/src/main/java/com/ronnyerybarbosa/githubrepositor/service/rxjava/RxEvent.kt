package com.ronnyerybarbosa.githubrepositor.service.rxjava

import com.ronnyerybarbosa.githubrepositor.data.response.RootResponseList


/**
 * @author ronnyeybarbosa on 28,November,2018
 */
class RxEvent {

    data  class EventAddPerson(val eventName:String, val eventProgress: Boolean, var isEmptyList: Boolean = false )

    data  class EventAddGeneric<T>(val eventName:String,
                                   val eventProgress: Boolean = false,
                                   var isEmptyList: Boolean = false,
                                   var obj: T? = null,
                                   var position: Int = 0,
                                   var rootObt: RootResponseList<T>? = null,
                                   var map: HashMap<String,Any>? = null )

    data  class EventAddGenericAux<T>(val eventName:String,
                                   val eventProgress: Boolean = false,
                                   var isEmptyList: Boolean = false,
                                   var obj: T? = null,
                                   var position: Int = 0,
                                   var rootObt: RootResponseList<T>? = null,
                                   var map: HashMap<String,Any>? = null )

}