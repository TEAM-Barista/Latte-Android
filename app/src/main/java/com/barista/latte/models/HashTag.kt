package com.barista.latte.models

/*
* Created by Juhyang on 2021/08/30
*/

data class HashTag(val name: String) {
    override fun toString(): String {
        return "#$name"
    }
}
