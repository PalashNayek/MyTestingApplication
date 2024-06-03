package com.palash.mytestingapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.palash.mytestingapplication.R
import com.palash.mytestingapplication.databinding.FragmentHomeBinding
import com.palash.mytestingapplication.models.newRecord.request.UserRequest
import com.palash.mytestingapplication.view_models.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        //All emp records........................................
        viewModel.getAllEmp()
        viewModel.allEmpLiveData.observe(viewLifecycleOwner, Observer {
            binding.txt.text = it.data.toString()
        })//////////////////////////////////////////////////////
        */


        /*
        //Single user
        viewModel.singleEmp()
        viewModel.singleEmpLiveData.observe(viewLifecycleOwner, Observer {
            binding.txt.text = it.data!!.data.employee_name
        })//////////////////////////////////////////
        */


        /*
        // create new user
        viewModel.createNewUser(UserRequest("30", "Sunny", "45000"))
        viewModel.createNewUserData.observe(viewLifecycleOwner, Observer {
            binding.txt.text = it.data!!.data.id.toString()
        })////////////////////////////////////////////////////////////////
        */


        /*// update user
        viewModel.updateUser(1, UserRequest("30", "Sunny", "45000"))
        viewModel.updateUserData.observe(viewLifecycleOwner, Observer {
            binding.txt.text = it.data!!.data.name
        })/////////////////////////////////
        */


        // delete user
        viewModel.deleteUser(5530)
        viewModel.deleteUserData.observe(viewLifecycleOwner, Observer {
            binding.txt.text = it.data!!.message
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}