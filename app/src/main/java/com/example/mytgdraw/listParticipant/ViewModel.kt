package com.example.mytgdraw.listParticipant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mytgdraw.Participant
import kotlin.random.Random

class ViewModel(inputString: String) : androidx.lifecycle.ViewModel() {

    private val _listParticipant = MutableLiveData<List<Participant>>()
    val listParticipant: LiveData<List<Participant>>
        get() = _listParticipant
    private val _winner = MutableLiveData<Participant>()
    val winner: LiveData<Participant>
    get() = _winner
    private val _countParticipant = MutableLiveData<Int>()
    val countParticipant:LiveData<Int>
    get() = _countParticipant

    init {
        var num = 1
        val listOfParticipant = mutableListOf<Participant>()
        inputString.split("\n").forEach {
            listOfParticipant.add(Participant(num, it))
            num++
        }
        _listParticipant.postValue(listOfParticipant)
        _countParticipant.postValue(listOfParticipant.size)
    }

    fun chooseWinner(){
        val listValues = 1..(_listParticipant.value?.size ?: 1)
        val winnerNum = listValues.random()
        _winner.value = _listParticipant.value?.filter {
            it.id == winnerNum
        }?.get(0)

    }
}