package com.example.api_ex


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class UsersAdapter(users: List<UsersItem?>?) : RecyclerView.Adapter<UsersAdapter.UsersHolder>() {

    lateinit var context: Context
    var UserList = users

    class UsersHolder(itemView: View) : ViewHolder(itemView) {


        var imgusers = itemView.findViewById<ImageView>(R.id.imeg)
        var txtname = itemView.findViewById<TextView>(R.id.txtname)
        var txtsurnam = itemView.findViewById<TextView>(R.id.txtsruname)
        var txtgender = itemView.findViewById<TextView>(R.id.txtgender)
        var txttage = itemView.findViewById<TextView>(R.id.txtage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersHolder {
        context=parent.context
        return UsersHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.users_item, parent, false)

        )
    }

    override fun onBindViewHolder(holder: UsersHolder, position: Int) {

        holder.txtname.text=UserList?.get(position)?.firstName
        holder.txtsurnam.text=UserList?.get(position)?.lastName
        holder.txttage.text=UserList?.get(position)?.age.toString()
        holder.txtgender.text=UserList?.get(position)?.gender
        Glide.with(context).load(UserList?.get(position)?.image).into(holder.imgusers)

    }



    override fun getItemCount(): Int {
        return UserList?.size!!
    }

}
