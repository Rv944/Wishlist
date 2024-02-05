/** # Android Project 2 - *Wishlist*

Submitted by: **Rothmel Fortune II**

**Custom_Wishlist** is a wishlist app that helps the user keep track of what they want to buy.

Time spent: **26** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **User can add an item to their wishlist**
- [x] **User can see their list of items based on previously inputted items**

The following **optional** features are implemented:

- [x] Wishlist app is 🎨 **customized** 🎨
- [ ] User can delete an item by long pressing on the item
- [ ] User can open an item's URL by clicking on the item

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExajcweHc5MTV3Ym0wemFzeHB0bXk5anFubTB5ZzRvM2ZxNDdkcXBkeCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/KJXkb9y21lKDYNhiUx/giphy.gif


GIF created with ... [ScreenToGif](https://www.screentogif.com/) for Windows


## Notes

Had a few difficulties when it came to the format when setting up the custom_layout.
The layout thinks the price is on top instead of the url. Kept switching it a few times,
but still show the same results.

## License

Copyright [2024]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
**/

package com.example.wishlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var wishlRv: RecyclerView
    private lateinit var userData: MutableList<UserData>
    private lateinit var e_name: EditText
    private lateinit var e_price: EditText
    private lateinit var e_url: EditText
    lateinit var submit: Button

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        e_name = findViewById(R.id.name)
        e_price = findViewById(R.id.price)
        e_url = findViewById(R.id.url)
        submit = findViewById(R.id.submit)
        userData = ArrayList()

        wishlRv = findViewById(R.id.wishlRv)
        val linearLayoutManager = LinearLayoutManager(this)
        wishlRv.layoutManager = linearLayoutManager

        // Create and set the custom adapter for the RecView
        var adapter = CustomAdapter(userData)
        wishlRv.adapter = adapter

        // Set an onClickListener for the submit button
        submit.setOnClickListener {
        // Get input values from EditText fields
        val name = e_name.text.toString()
        val price = e_price.text.toString()
        val url = e_url.text.toString()

        //fun onLongClickListener(position: Int){
            //userData.removeAt(position)
            //CustomAdapter.ItemRemovedList(position)

            //Toast.makeText(this, "It has been removed $position", Toast.LENGTH_SHORT).show()
       // }

        // Create a UserData object with the input data
        val mUserData = UserData(name, price, url)

        // Add the UserData object to the list
            userData.add(mUserData)

        // Notify the adapter that the data has changed
        adapter.notifyDataSetChanged()

        // Clear the input fields
        clearFields()
        }
        }

        // Helper method to clear input fields
    private fun clearFields() {
        e_name.setText("")
        e_price.setText("")
        e_url.setText("")
        }


    }

