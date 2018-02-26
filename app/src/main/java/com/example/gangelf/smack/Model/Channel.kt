package com.example.gangelf.smack.Model

/**
 * Created by Gangelf on 2/25/2018.
 */
class Channel(val name: String, val desc: String, val id: String) {
    override fun toString(): String {
        return "#$name"
    }
}