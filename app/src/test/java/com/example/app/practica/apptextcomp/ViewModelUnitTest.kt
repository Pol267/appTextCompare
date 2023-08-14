package com.example.app.practica.apptextcomp
import androidx.arch.core.executor.TaskExecutor
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import java.time.Instant

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ViewModelUnitTest {
    private lateinit var viewModel: TextComparisonViewModel
    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    private val dispatcher = StandardTestDispatcher()
   @Before
    fun setup(){
       Dispatchers.setMain(dispatcher)
        viewModel=TextComparisonViewModel()
    }
    @After
    fun tearDown(){
        Dispatchers.resetMain()

    }
    @Test
    fun MainViewModel_CheckInitialValuetxt1() = runTest{
        var value1 = viewModel.text1

        assertEquals("",value1)

    }
    @Test
    fun MainViewModel_CheckInitialValuetxt2() = runTest{
        var value2 = viewModel.text2

        assertEquals("",value2)

    }
    @Test
    fun MainViewModel_TestIguales() = runTest {
launch {
    var value1 = "a"
    var value2 = "a"
    viewModel.text1 = value1
    viewModel.text2 = value2
    viewModel.compareTexts()
}

    advanceUntilIdle()

        var result = viewModel.comparisonResult.value
        assertEquals("Los textos son iguales",result )
    }

    @Test
    fun MainViewModel_TestDif() = runTest {
        launch {
            var value1 = "a"
            var value2 = "b"
            viewModel.text1 = value1
            viewModel.text2 = value2
            viewModel.compareTexts()
        }

        advanceUntilIdle()

        var result = viewModel.comparisonResult.value
        assertEquals("Los textos son distintos",result )
    }

}


