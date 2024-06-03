package com.palash.mytestingapplication.api_service

import com.palash.mytestingapplication.models.getAllEmpResponse.AllEmpResponse
import com.palash.mytestingapplication.models.newRecord.request.UserRequest
import com.palash.mytestingapplication.models.newRecord.response.UserResponse
import com.palash.mytestingapplication.models.singleEmp.SingleEmp
import com.palash.mytestingapplication.models.userDelete.UserDeleteResponse
import retrofit2.Response
import retrofit2.http.*

interface UnauthorisedAPI {

    @GET("api/v1/employees")
    suspend fun getAllEmp(): Response<AllEmpResponse>

    @GET("api/v1/employee/1")
    suspend fun singleEmp(): Response<SingleEmp>

    @POST("api/v1/create")
    suspend fun createNewUser(@Body userRequest: UserRequest): Response<UserResponse>

    @PUT("api/v1/update/{id}")
    suspend fun updateUser(
        @Path("id") userId: Int,
        @Body userRequest: UserRequest
    ): Response<UserResponse>

    @DELETE("api/v1/delete/{id}")
    suspend fun userDelete(@Path("id") userId: Int) : Response<UserDeleteResponse>

}