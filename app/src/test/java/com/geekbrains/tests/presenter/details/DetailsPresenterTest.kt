package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    private val count = 5

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailsPresenter(viewContract)
    }

    @Test
    fun `test setCounter success`() {
        presenter.setCounter(count)

        assertEquals(count, presenter.count)
    }

    @Test
    fun `test onIncrement success`() {
        presenter.setCounter(count)
        presenter.onIncrement()

        verify(viewContract, times(1))
            .setCount(count + 1)
    }

    @Test
    fun `test onDecrement success`() {
        presenter.setCounter(count)
        presenter.onDecrement()

        verify(viewContract, times(1))
            .setCount(count - 1)
    }

    @Test
    fun `test onAttach success`() {
        presenter.onAttach()

        assertEquals(0, presenter.count)
    }

    @Test
    fun `test onDeatch success`() {
        presenter.onDetach()

        assertEquals(0, presenter.count)
    }

}