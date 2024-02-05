package com.example.wishlist



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class CustomAdapter(private val userData: MutableList<UserData>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    // CustomViewHolder class to hold and manage the views for each item in the RecyclerView
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView


       init{
           nameTextView = itemView.findViewById(R.id.nameText)
           priceTextView = itemView.findViewById(R.id.priceText)
           urlTextView = itemView.findViewById(R.id.urlText)

       }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // Inflate the custom layout for each item in the RecyclerView
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.custom_layout, parent, false)
        // Create a CustomViewHolder to hold the view
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        // Return the number of items in the RecyclerView (equal to the size of the UserData list)
        return userData.size
    }

    //fun ItemRemovedList(position: Int){
       // notifyItemRemoved(position)
   // }

    override fun onBindViewHolder( holder: CustomViewHolder, position: Int) {
        // Populate the ViewHolder with data from the UserData object at the given position
        val wishlistItem = userData.get(position)
        holder.nameTextView.text = wishlistItem.name
        holder.priceTextView.text = wishlistItem.price
        holder.urlTextView.text = wishlistItem.url
    }




}