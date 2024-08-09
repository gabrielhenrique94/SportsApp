package com.kainzengaming.sport.sports.presentation

import FULL_MOCK
import FULL_MOCK_WITH_FAVORITES
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.usecase.FavoriteEventUseCase
import com.kainzengaming.sport.sports.domain.usecase.GetSportsUseCases
import com.kainzengaming.sport.sports.presentation.mapper.toDataUi
import com.kainzengaming.sport.sports.presentation.model.EventDataUi
import com.kainzengaming.sport.sports.presentation.model.EventsDataUi
import com.kainzengaming.sport.sports.presentation.model.SportDataUi
import com.kainzengaming.sport.util.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SportsViewModelTest {

    @get:Rule
    val mockkRule = MockKRule(this)

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    val taskRule = InstantTaskExecutorRule()

    @MockK
    lateinit var getSportsUseCase: GetSportsUseCases

    @MockK(relaxed = true)
    lateinit var favoriteEventUseCase: FavoriteEventUseCase

    private lateinit var viewModel: SportsViewModel

    @Before
    fun setUp() {
        coEvery { getSportsUseCase() } returns flow { emit(FULL_MOCK) }
        viewModel = SportsViewModel(getSportsUseCase, favoriteEventUseCase)
    }

    @Test
    fun `ViewModel should call getSportsUseCase and return a list of sports on Resume `() {
        viewModel.onResume()
        coVerify { getSportsUseCase() }
        assert(viewModel.sportsLiveData.value == FULL_MOCK.toDataUi())
    }

    @Test
    fun `ViewModel should persist the favorite event and return the correct list when an event is clicked and it is not favorite`() {
        viewModel.onResume()

        viewModel.onEventClick(
            EventDataUi(
                id = "49906591",
                name = "Birkenhead United - West Coast Rangers",
                startTime = 1723146960,
                sportId = "FOOT",
                isFavorite = false
            )
        )

        coVerify {
            favoriteEventUseCase(
                Event(
                    id = "49906591",
                    name = "Birkenhead United - West Coast Rangers",
                    startTime = 1723146960,
                    isFavorite = false
                )
            )
        }
        val list = viewModel.sportsLiveData.value
        val events = list?.findAllEvents("49906591")
        assert(events?.all { it.isFavorite } ?: false)
    }

    @Test
    fun `ViewModel should remove the favorite event and return the correct list when an event is clicked and it is favorite`() {
        viewModel.onResume()

        viewModel.onEventClick(
            EventDataUi(
                id = "49906591",
                name = "Birkenhead United - West Coast Rangers",
                startTime = 1723146960,
                sportId = "FOOT",
                isFavorite = true
            )
        )

        coVerify {
            favoriteEventUseCase(
                Event(
                    id = "49906591",
                    name = "Birkenhead United - West Coast Rangers",
                    startTime = 1723146960,
                    isFavorite = true
                )
            )
        }
        val list = viewModel.sportsLiveData.value
        val events = list?.findAllEvents("49906591")
        assert(events?.all { it.isFavorite.not() } ?: false)
    }

    @Test
    fun `ViewModel should filter all non favorites events when click filter button and is not filtering`() {
        coEvery { getSportsUseCase() } returns flow { emit(FULL_MOCK_WITH_FAVORITES) }

        viewModel.onResume()
        viewModel.onSportsFilterClick(FULL_MOCK_WITH_FAVORITES.toDataUi().first() as SportDataUi)

        val list = viewModel.sportsLiveData.value
        val eventsList: Any? = list?.get(1)
        val sport: SportDataUi = list?.first() as SportDataUi

        assert(sport.isFiltered)
        assert(eventsList is EventsDataUi)
        val events = (eventsList as EventsDataUi).events

        assertEquals(4, events.size)
        assert(events.all { it.isFavorite })
    }

    @Test
    fun `ViewModel should not filter all non favorites events when click filter button and is filtering`() {
        coEvery { getSportsUseCase() } returns flow { emit(FULL_MOCK_WITH_FAVORITES) }

        viewModel.onResume()
        //filter
        viewModel.onSportsFilterClick(FULL_MOCK_WITH_FAVORITES.toDataUi().first() as SportDataUi)
        //remove filter
        viewModel.onSportsFilterClick(
            (FULL_MOCK_WITH_FAVORITES.toDataUi().first() as SportDataUi).copy(isFiltered = true)
        )

        val list = viewModel.sportsLiveData.value
        val eventsList: Any? = list?.get(1)
        val sport: SportDataUi = list?.first() as SportDataUi

        assertFalse(sport.isFiltered)
        assert(eventsList is EventsDataUi)
        val events = (eventsList as EventsDataUi).events
        assertEquals(21, events.size)
        assert(events.any { it.isFavorite.not() })
    }

    @Test
    fun `ViewModel should collapse when click collapse button and is expanded `() {
        viewModel.onResume()
        viewModel.onSportsExpandClick((FULL_MOCK.toDataUi().first() as SportDataUi))

        val list = viewModel.sportsLiveData.value
        val eventsList: Any? = list?.get(1)
        val sport: SportDataUi = list?.first() as SportDataUi

        assertFalse(sport.isOpened)
        assertFalse(eventsList is EventsDataUi)
    }

    @Test
    fun `ViewModel should expand when click collapse button and is collapsed `() {
        viewModel.onResume()
        //collapse
        viewModel.onSportsExpandClick((FULL_MOCK.toDataUi().first() as SportDataUi))
        //expand
        viewModel.onSportsExpandClick(viewModel.sportsLiveData.value?.first() as SportDataUi)

        val list = viewModel.sportsLiveData.value
        val eventsList: Any? = list?.get(1)
        val sport: SportDataUi = list?.first() as SportDataUi

        assert(sport.isOpened)
        assert(eventsList is EventsDataUi)
        val events = (eventsList as EventsDataUi).events
        assertEquals(21, events.size)
    }

    private fun List<Any>.findAllEvents(eventId: String): MutableList<EventDataUi> {
        val filteredEvents = mutableListOf<EventDataUi>()
        this.forEach { holder ->
            when (holder) {
                is SportDataUi -> {
                    filteredEvents.addAll(holder.events.filter { it.id == eventId })
                }

                is EventsDataUi -> {
                    filteredEvents.addAll(holder.events.filter { it.id == eventId })
                }
            }
        }
        return filteredEvents
    }
}