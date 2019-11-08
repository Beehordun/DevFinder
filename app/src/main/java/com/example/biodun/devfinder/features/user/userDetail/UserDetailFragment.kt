package com.example.biodun.devfinder.features.user.userDetail


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.biodun.devfinder.BaseFragment
import com.example.biodun.devfinder.R
import com.example.biodun.devfinder.di.FragmentModule
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment : BaseFragment() {

    lateinit var userName: String
    lateinit var avatarUrl: String
    lateinit var htmlUrl: String
    private val args: UserDetailFragmentArgs by navArgs()

    override fun performInjection() {
        super.performInjection()
        fragmentComponent = activityComponent?.plus(FragmentModule)
        fragmentComponent?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userName = args.userName
        avatarUrl = args.avatarUrl
        htmlUrl = args.htmlUrl

        configureUI()
    }

    private fun configureUI() {
        userProfileName.text = userName
        userHtml.text = htmlUrl
        Picasso.with(context).load(avatarUrl)
                .placeholder(R.drawable.images)
                .resize(80, 80)
                .into(userAvatar)

        shareButton.setOnClickListener {
            val message = "Check out this awesome developer @ " + args + " " + userHtml.text
            val intents = Intent(Intent.ACTION_SEND)

            intents.type = "text/plain"
            intents.putExtra(Intent.EXTRA_TEXT, message)

            startActivity(Intent.createChooser(intents, "Share"))
        }
    }
}
