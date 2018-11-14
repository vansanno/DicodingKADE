package com.example.adnavon.footballapi.adapter

import android.renderscript.Type
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.adnavon.footballapi.R
import com.example.adnavon.footballapi.R.id.team_badge
import com.example.adnavon.footballapi.R.id.team_name
import com.example.adnavon.footballapi.model.Team
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class  MainAdapter(private val teams: List<Team>)
    :RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(TeamUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(parent: TeamViewHolder, position: Int) {
        parent.bindItem(teams [position])
    }

    override fun getItemCount(): Int = teams.size
}

    class TeamUI: AnkoComponent<ViewGroup>{
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui){
                linearLayout {
                    lparams(width= matchParent, height = matchParent)
                    padding = dip (16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.team_badge
                    }.lparams {
                        height = dip(50)
                        width = dip(50)
                    }

                    textView {
                        id = R.id.team_name
                        textSize = 16f
                    }.lparams {
                        margin = dip(16)
                    }
                }
            }
        }
    }

class TeamViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val teamBadge: ImageView = view.find(team_badge)
        private val teamName: TextView = view.find(team_name)

    fun bindItem(teams: Team){
        Picasso.get().load(teams.teamBadge).into(teamBadge)
        teamName.text = teams.teamName
    }
}
