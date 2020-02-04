package com.example.biodun.devfinder.features.user.userList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.biodun.devfinder.BaseFragment
import com.example.biodun.devfinder.R
import com.example.biodun.devfinder.di.FragmentModule
import com.example.biodun.devfinder.model.User
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_user_list.*
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import javax.inject.Inject

private const val searchParam = "language:java location:lagos"

class UserListFragment : BaseFragment(), UserListView {

    @Inject lateinit var presenter: UserListPresenter

    var users: List<User> = emptyList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun performInjection() {
        fragmentComponent = activityComponent?.plus(FragmentModule)
        fragmentComponent?.inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
        presenter.syncData(searchParam)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun configureRecyclerView(users: List<User>) {
        userListRecyclerView.adapter = UserListAdapter(users)
        userListRecyclerView.layoutManager = GridLayoutManager(context, 2)
        userListRecyclerView.setHasFixedSize(true)
        userListRecyclerView.adapter?.notifyDataSetChanged()
    }

    override fun goToUserDetailScreen(user: User) {
        val action = UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(user.userName, user.avatarUrl, user.htmlUrl)
        this.findNavController().navigate(action)
    }

    override fun onDestroyView() {
        presenter.cancelNetworkSubscriptions()
        super.onDestroyView()
    }

    inner class UserListAdapter(
            private val users: List<User>
    ): RecyclerView.Adapter<UserListAdapter.ViewHolder>()  {

        override fun getItemCount() = users.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,
                    parent,
                    false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val user = users[position]
            holder.userName.text = user.userName
            Picasso.with(context)
                    .load(user.avatarUrl)
                    .placeholder(R.drawable.images)
                    .resize(80, 80)
                    .into(holder.userAvatar)
        }


        inner class ViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
            val userName: TextView = v.userName
            val userAvatar: CircleImageView = v.userAvatar

            init {
                v.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                goToUserDetailScreen(users[adapterPosition])
            }
        }
    }
}
