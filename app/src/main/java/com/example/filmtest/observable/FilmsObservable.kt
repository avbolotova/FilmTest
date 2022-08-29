package com.example.filmtest.observable

import java.util.*

abstract class FilmsObservable {

    protected val observers = LinkedList<FilmsObserver>()

    fun addObserver(observer: FilmsObserver) = observers.add(observer)

    fun removeObserver(observer: FilmsObserver) = observers.remove(observer)

    fun clear() = observers.clear()

    abstract fun notifyObservers()

}