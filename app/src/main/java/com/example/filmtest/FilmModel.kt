package com.example.filmtest

class FilmModel {
    var uid: String = ""
    var id: String = ""
    var title: String = ""
    var description: String = ""
    var favorite: Boolean = false

    constructor()

    constructor(uid: String, id: String, title: String, description: String, favorite: Boolean) {
        this.uid = uid
        this.id = id
        this.title = title
        this.description = description
        this.favorite = favorite
    }


}