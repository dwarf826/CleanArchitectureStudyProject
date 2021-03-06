package com.chazo.personal.two.cleanarchitecturestudy.data.google_calender

import com.chazo.personal.two.cleanarchitecturestudy.data.google_calender.remote.GoogleCalendarRemoteDataSource
import com.google.api.services.calendar.model.CalendarList
import com.google.api.services.calendar.model.Event
import io.reactivex.Single
import javax.inject.Inject

class GoogleCalendarRepository @Inject constructor(private val remote: GoogleCalendarRemoteDataSource): GoogleCalendarDataSource {
    override fun getCalendarList(): Single<CalendarList> {
        return remote.getCalendarList()
    }

    override fun getEvents(calendarId: String): Single<List<Event>> {
        return remote.getEvents(calendarId)
    }
}