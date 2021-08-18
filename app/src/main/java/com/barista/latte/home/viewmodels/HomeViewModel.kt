package com.barista.latte.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barista.latte.models.Interview
import com.barista.latte.models.Post
import com.barista.latte.viewmodels.InterviewViewModel
import timber.log.Timber

class HomeViewModel : ViewModel() {

    private val _currentWeekInterview: MutableLiveData<Interview> = MutableLiveData<Interview>()
    val currentWeekInterview: LiveData<Interview>
        get() {
            return _currentWeekInterview
        }

    private val _postList: MutableLiveData<List<Post>> = MutableLiveData()
    val postList: LiveData<List<Post>>
        get() {
            return _postList
        }

    fun loadData() {
        _currentWeekInterview.value = Interview("3rd-year developer", "Our public platform servers 100 million people every month, making it one of the 50 most popular websites")

        val postList = ArrayList<Post>()
        for (i in 0 until 5) {
            postList.add(Post("Headline-1line", "Envision this: there is a technology currently undergoing testing that, when released to the public, will become a long-awaited revolution in energy. This new technology promises to be safer and more efficient than anything we have on the market now. It will affect that which we consider mundane — power tools, toys, laptops, smartphones — and that which we consider exceptional — medical devices, spacecraft, and the innovative new vehicle designs needed to wean us off of fossil fuels.\n" +
                    "\n" +
                    "We have known about this technology for centuries, yet until now we have only been able to take small steps towards its creation. Billions of dollars are pouring into research and billions more will be made once the technology has been perfected and released.\n" +
                    "\n" +
                    "This description may sound a lot like that of fusion power. Yet it’s actually referring to the upcoming innovations in the realm of battery technology — specifically that of solid-state batteries. And while both fusion power and solid-state batteries have been labeled technologies of the future but never of today, advancements and investments in solid-state materials have increased tremendously over the years. Today not only are there many major companies and credible researchers involved, it seems we may finally start seeing these batteries released in just the next few years.\n" +
                    "\n" +
                    "A research team led by physicist John Goodenough has submitted a patent for a glass and ceramic solid-state battery that is stable, non-flammable, offers faster charging, and has 3 times more energy storage than a regular lithium-ion battery. This was achieved by adding sodium or lithium to form an electrode in the battery. Equally as important, the battery is affordable and is estimated to last over 2,000 charge and discharge cycles. Operating temperature range for the glass battery is between -4º F and 140º F (-20º C and 60º C).", "Minky", 1000, 1000, null))
        }
        _postList.value = postList
    }

    fun requestInterviewAction() {
        Timber.d("#juhyang requestInterviewAction")
    }
}
