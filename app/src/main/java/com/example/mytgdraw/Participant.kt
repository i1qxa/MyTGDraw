package com.example.mytgdraw

data class Participant(
    val id:Int,
    val name:String,
){
    fun getHiddenNumber():String{
        val regex = """\+\d{7}"""
        return Regex(regex).replace(name,"********")
    }
}
