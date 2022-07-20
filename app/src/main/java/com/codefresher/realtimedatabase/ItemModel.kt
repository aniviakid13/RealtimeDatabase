package com.codefresher.realtimedatabase


class ItemModel {
    var img: String? = null
    var title: String? = null

    constructor()
    constructor(
        img: String?,
        title: String?
    ) {
        this.img = img
        this.title = title

    }
}
