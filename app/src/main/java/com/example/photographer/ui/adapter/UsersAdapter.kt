package com.example.photographer.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.photographer.R
import com.example.photographer.business.model.User
import com.squareup.picasso.Picasso

class UsersAdapter(val userList: ArrayList<User>, val onItemClick: (user: User) -> Unit): RecyclerView.Adapter<UsersAdapter.UserVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val inflater = LayoutInflater.from(parent.context)
        val rootView = inflater.inflate(R.layout.item_user, parent, false)
        return UserVH(rootView)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val user = userList.get(position)
        val fullName = user.firstName + user.lastName
        holder.name.text = fullName
        user.image.let {
            Picasso.get().load(it).into(holder.photo)
        }
        holder.view.setOnClickListener{ onItemClick.invoke(user) }
    }

    class UserVH(view: View): RecyclerView.ViewHolder(view) {
        val view: View = view
        val photo: ImageView = view.findViewById(R.id.photo)
        val name: TextView = view.findViewById(R.id.name)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}