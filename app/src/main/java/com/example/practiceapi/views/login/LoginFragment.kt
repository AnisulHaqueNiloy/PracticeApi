package com.example.practiceapi.views.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.practiceapi.R
import com.example.practiceapi.databinding.FragmentLoginBinding
import com.example.practiceapi.model.login.RequestLogin
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
   lateinit var binding: FragmentLoginBinding
   private val viewModel : LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater,container,false)
        viewModel.responsedata.observe(viewLifecycleOwner){
            if (it.isSuccessful){
                Log.d("TAG","Msg ${it.body()}")
                findNavController().navigate(R.id.action_loginFragment_to_productFragment)
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener {
            var username = binding.userName.text.toString().trim()
            var password =binding.password.text.toString()
            if (username.isNullOrEmpty()){
                binding.userName.error = "Username cannot be empty"
            }
            else if (password.isNullOrEmpty()){
                binding.password.error="Password field  cannot be empty"
            }

            else {
                handlelogin(username,password)
            }

        }
    }

    private fun handlelogin(username: String, password: String) {

        val request = RequestLogin(username = username, password=password)
        viewModel.login(request)

    }


}