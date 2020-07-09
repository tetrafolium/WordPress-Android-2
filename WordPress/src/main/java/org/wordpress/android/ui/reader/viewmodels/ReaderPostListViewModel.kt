package org.wordpress.android.ui.reader.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import org.wordpress.android.models.ReaderTag
import org.wordpress.android.models.news.NewsItem
import org.wordpress.android.ui.news.NewsManager
import org.wordpress.android.ui.news.NewsTracker
import org.wordpress.android.ui.news.NewsTracker.NewsCardOrigin.READER
import org.wordpress.android.ui.news.NewsTrackerHelper

class ReaderPostListViewModel @Inject constructor(
    private val newsManager: NewsManager,
    private val newsTracker: NewsTracker,
    private val newsTrackerHelper: NewsTrackerHelper
) : ViewModel() {
    private val newsItemSource = newsManager.newsItemSource()
    private val _newsItemSourceMediator = MediatorLiveData<NewsItem>()

    private val onTagChanged: Observer<NewsItem?> = Observer { _newsItemSourceMediator.value = it }

    /**
     * First tag for which the card was shown.
     */
    private var initialTag: ReaderTag? = null
    private var isStarted = false

    /**
     * Tag may be null for Blog previews for instance.
     */
    fun start(tag: ReaderTag?) {
        if (isStarted) {
            return
        }
        tag?.let {
            onTagChanged(tag)
            newsManager.pull()
        }
        isStarted = true
    }

    fun getNewsDataSource(): LiveData<NewsItem> {
        return _newsItemSourceMediator
    }

    fun onTagChanged(tag: ReaderTag?) {
        newsTrackerHelper.reset()
        tag?.let { newTag ->
            // show the card only when the initial tag is selected in the filter
            if (initialTag == null || newTag == initialTag) {
                _newsItemSourceMediator.addSource(newsItemSource, onTagChanged)
            } else {
                _newsItemSourceMediator.removeSource(newsItemSource)
                _newsItemSourceMediator.value = null
            }
        }
    }

    fun onNewsCardDismissed(item: NewsItem) {
        newsTracker.trackNewsCardDismissed(READER, item.version)
        newsManager.dismiss(item)
    }

    fun onNewsCardShown(
        item: NewsItem,
        currentTag: ReaderTag
    ) {
        initialTag = currentTag
        if (newsTrackerHelper.shouldTrackNewsCardShown(item.version)) {
            newsTracker.trackNewsCardShown(READER, item.version)
            newsTrackerHelper.itemTracked(item.version)
        }
        newsManager.cardShown(item)
    }

    fun onNewsCardExtendedInfoRequested(item: NewsItem) {
        newsTracker.trackNewsCardExtendedInfoRequested(READER, item.version)
    }

    override fun onCleared() {
        super.onCleared()
        newsManager.stop()
    }
}
