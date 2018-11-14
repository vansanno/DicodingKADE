package com.example.adnavon.footballapi.presenter

import com.example.adnavon.footballapi.api.ApiRepository
import com.example.adnavon.footballapi.TheSportDBApi
import com.example.adnavon.footballapi.model.TeamResponse
import com.example.adnavon.footballapi.view.MainView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private var view: MainView,
                    private var apiRepository: ApiRepository,
                    private var gson: Gson){
    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeams(league)),
                    TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}