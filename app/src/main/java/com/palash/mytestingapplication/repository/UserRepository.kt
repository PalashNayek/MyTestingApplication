package com.palash.mytestingapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.palash.mytestingapplication.api_service.UnauthorisedAPI
import com.palash.mytestingapplication.models.getAllEmpResponse.AllEmpResponse
import com.palash.mytestingapplication.models.newRecord.request.UserRequest
import com.palash.mytestingapplication.models.newRecord.response.UserResponse
import com.palash.mytestingapplication.models.singleEmp.SingleEmp
import com.palash.mytestingapplication.models.userDelete.UserDeleteResponse
import com.palash.mytestingapplication.utils.NetworkResult
import org.json.JSONObject
import javax.inject.Inject

class UserRepository @Inject constructor(private val unauthorisedAPI: UnauthorisedAPI) {

    private var _empData = MutableLiveData<NetworkResult<AllEmpResponse>>()
    val empLivedata: LiveData<NetworkResult<AllEmpResponse>> get() = _empData
    suspend fun getAllEmployee() {
        val response = unauthorisedAPI.getAllEmp()
        if (response.isSuccessful && response.body() != null) {
            _empData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val msg = JSONObject(response.errorBody()!!.charStream().readText())
            _empData.postValue(NetworkResult.Error(msg.getString("message")))
        } else {
            _empData.postValue(NetworkResult.Error("Server error"))
        }
        Log.d("MyResponse", response.body().toString())
    }

    //Single emp
    private var _singleEmpData = MutableLiveData<NetworkResult<SingleEmp>>()
    val singleEmpLivedata: LiveData<NetworkResult<SingleEmp>> get() = _singleEmpData
    suspend fun singleEmp() {
        val response = unauthorisedAPI.singleEmp()
        if (response.isSuccessful && response.body() != null) {
            _singleEmpData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val msg = JSONObject(response.errorBody()!!.charStream().readText())
            _singleEmpData.postValue(NetworkResult.Error(msg.getString("message")))
        } else {
            _singleEmpData.postValue(NetworkResult.Error("Server error"))
        }
    }

    //new user
    private var _newUserData = MutableLiveData<NetworkResult<UserResponse>>()
    val newUserData: LiveData<NetworkResult<UserResponse>> get() = _newUserData
    suspend fun newUser(userRequest: UserRequest) {
        val response = unauthorisedAPI.createNewUser(userRequest)
        if (response.isSuccessful && response.body() != null) {
            _newUserData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val msg = JSONObject(response.errorBody()!!.charStream().readText())
            _newUserData.postValue(NetworkResult.Error(msg.getString("message")))
        } else {
            _newUserData.postValue(NetworkResult.Error("Server error"))
        }
    }

    //update user
    private var _updateUserdata = MutableLiveData<NetworkResult<UserResponse>>()
    val updateUserData: LiveData<NetworkResult<UserResponse>> get() = _updateUserdata
    suspend fun updateUser(userId: Int, userRequest: UserRequest) {
        val response = unauthorisedAPI.updateUser(userId, userRequest)
        if (response.isSuccessful && response.body() != null) {
            _updateUserdata.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            try {
                val msg = JSONObject(response.errorBody()!!.charStream().readText())
                _updateUserdata.postValue(NetworkResult.Error(msg.getString("message")))
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        } else {
            _updateUserdata.postValue(NetworkResult.Error("Server error"))
        }
    }

    //user delete
    private var _userDeleteData = MutableLiveData<NetworkResult<UserDeleteResponse>>()
    val deleteUserData: LiveData<NetworkResult<UserDeleteResponse>> get() = _userDeleteData
    suspend fun deleteUser(id: Int) {
        val response = unauthorisedAPI.userDelete(id)
        if (response.isSuccessful && response.body() != null) {
            _userDeleteData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            try {
                val msg = JSONObject(response.errorBody()!!.charStream().readText())
                _userDeleteData.postValue(NetworkResult.Error(msg.getString("message")))
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        } else {
            _userDeleteData.postValue(NetworkResult.Error("Server error"))
        }
    }

}