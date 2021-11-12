package com.example.cardinfofinder

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cardinfofinder.data.remote.LookupBinService
import com.example.cardinfofinder.data.remote.info_finder.InfoFinderHelper
import com.example.cardinfofinder.ui.info_finder.repositories.InfoFinderRepository
import com.example.cardinfofinder.ui.info_finder.viewmodels.InputCardDetailsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.*

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class InputCardDetailsViewModelTest {

    private lateinit var viewModel: InputCardDetailsViewModel

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should pass in correct card number to repository and helper classes from viewmodel`() = runBlockingTest {
        val expectedCardNumber = "12341212"

        val lookupBinService: LookupBinService = mock()
        val infoFinderHelper = InfoFinderHelper(lookupBinService)
        val infoFinderRepository = InfoFinderRepository(infoFinderHelper)

        viewModel = InputCardDetailsViewModel(infoFinderRepository)

        viewModel.lookup(expectedCardNumber)

        verify(lookupBinService, times(1)).lookupBIN(expectedCardNumber)
    }

}