package com.palash.mytestingapplication.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palash.mytestingapplication.models.getAllEmpResponse.AllEmpResponse
import com.palash.mytestingapplication.models.newRecord.request.UserRequest
import com.palash.mytestingapplication.models.newRecord.response.UserResponse
import com.palash.mytestingapplication.models.singleEmp.SingleEmp
import com.palash.mytestingapplication.models.userDelete.UserDeleteResponse
import com.palash.mytestingapplication.repository.UserRepository
import com.palash.mytestingapplication.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val allEmpLiveData : LiveData<NetworkResult<AllEmpResponse>> get() = userRepository.empLivedata

    fun getAllEmp(){
       viewModelScope.launch {
           userRepository.getAllEmployee()
       }
    }

    val singleEmpLiveData: LiveData<NetworkResult<SingleEmp>> get() = userRepository.singleEmpLivedata
    fun singleEmp(){
        viewModelScope.launch {
            userRepository.singleEmp()
        }
    }

    val createNewUserData: LiveData<NetworkResult<UserResponse>> get() = userRepository.newUserData
    fun createNewUser(userRequest: UserRequest){
        viewModelScope.launch {
            userRepository.newUser(userRequest)
        }
    }

    val updateUserData: LiveData<NetworkResult<UserResponse>> get() = userRepository.updateUserData
    fun updateUser(userId: Int, userRequest: UserRequest){
        viewModelScope.launch {
            userRepository.updateUser(userId, userRequest)
        }
    }

    val deleteUserData: LiveData<NetworkResult<UserDeleteResponse>> get() = userRepository.deleteUserData
    fun deleteUser(userId: Int){
        viewModelScope.launch {
            userRepository.deleteUser(userId)
        }
    }


}