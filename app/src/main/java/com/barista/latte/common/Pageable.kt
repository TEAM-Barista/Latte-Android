package com.barista.latte.common

/*
* Created by Juhyang on 2021/12/09
*/

data class Pageable<T>(
        val content: T,
        val empty : Boolean,
        val first : Boolean,
        val last : Boolean
)
