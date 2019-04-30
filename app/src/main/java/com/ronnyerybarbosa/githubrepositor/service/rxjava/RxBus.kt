package com.ronnyerybarbosa.githubrepositor.service.rxjava

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * @author ronnyeybarbosa on 28,November,2018
 */
object RxBus
{

    private val publisher = PublishSubject.create<Any>()

    fun publish(event: Any) {
        publisher.onNext(event)
    }

    // Listen should return an Observable and not the publisher
    // Using ofType we filter only events that match that class type
    fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)
}