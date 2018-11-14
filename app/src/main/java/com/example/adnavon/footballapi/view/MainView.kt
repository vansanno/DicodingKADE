package com.example.adnavon.footballapi.view

import com.example.adnavon.footballapi.model.Team

interface MainView{
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}