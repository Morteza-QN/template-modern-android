package me.morteza.modernlayer.ui.main

class SampleMainViewModel

/*
**************************** STEP 1*******************************+

class MainViewModel(private val repository: GithubRepository) : ViewModel() {

    private val _githubResponseData = MutableLiveData<Result<GithubResponseModel>>()
    val githubResponseData: LiveData<Result<GithubResponseModel>> = _githubResponseData

    var dataAdapter: DataAdapter = DataAdapter()

    init {
        makeApiCall()
    }

    fun getAdapter(): DataAdapter {
        return dataAdapter
    }

    fun setAdapterData(data: ArrayList<MyData>) {
        dataAdapter.setData(data)
        dataAdapter.notifyDataSetChanged()
    }


    private fun makeApiCall(input: String? = null) {
        repository.getAllRepository("kotlin")
            .enqueue(object : retrofit2.Callback<GithubResponseModel> {
                override fun onFailure(call: Call<GithubResponseModel>, t: Throwable) {
                    _githubResponseData.value = null
                }

                override fun onResponse(
                    call: Call<GithubResponseModel>,
                    response: Response<GithubResponseModel>
                ) {
                    if (response.isSuccessful) {
                        _githubResponseData.value = Result.Success(response.body()!!)
                    } else {
                        _githubResponseData.value = Result.Error(
                            Exception("API call failed with code: ${response.code()}"),
                            ("Error code : ${response.message()}")
                        )
                    }
                }

            })
    }
}

* */

/*
******************************* STEP 2 ****************************

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(
        val exception: Exception,
        val errorMessage: String,
    ) : Result<Nothing>()

}
*
* step 3
private val _githubResponseData = MutableLiveData<Result<GithubResponseModel>>()
val githubResponseData: LiveData<Result<GithubResponseModel>> = _githubResponseData

*
private fun makeApiCall(input: String? = null) {
    repository.getAllRepository("kotlin")
        .enqueue(object : retrofit2.Callback<GithubResponseModel> {
            override fun onFailure(call: Call<GithubResponseModel>, t: Throwable) {
                _githubResponseData.value = null
            }

            override fun onResponse(
                call: Call<GithubResponseModel>,
                response: Response<GithubResponseModel>
            ) {
                if (response.isSuccessful) {
                    _githubResponseData.value = Result.Success(response.body()!!)
                } else {
                    _githubResponseData.value = Result.Error(
                        Exception("API call failed with code: ${response.code()}"),
                        ("Error code : ${response.message()}")
                    )
                }
            }


        })

}
*
*
private fun initObserver() {

    mainViewModel.githubResponseData.observe(viewLifecycleOwner, Observer {result ->
        when (result) {
            is Result.Success -> {
                binding.progressbar.visibility = View.INVISIBLE
                mainViewModel.setAdapterData(result.data.items)
            }
            is Result.Error -> {
                Toast.makeText(requireContext(), "Error Fetching Data", Toast.LENGTH_LONG).show()
            }
        }
    })

}
* // https://github.com/abdulqadirtr/Kotlin_ViewModel_Databinding
* */