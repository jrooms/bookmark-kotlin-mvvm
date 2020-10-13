package com.example.bookmarkse_kotlin.data.source

import com.example.bookmarkse_kotlin.data.Bookmark

interface BookmarkDataSource {

    interface LoadBookmarksCallback {
        fun onBookmarksLoaded(bookmarks: List<Bookmark>)
        fun onDataNotAvailable()
    }

    interface GetBookmarkCallback {
        fun onBookmarkLoaded(book: Bookmark)
        fun onDataNotAvailable()
    }

    fun getBookmarks(callback: LoadBookmarksCallback)

    fun getBookmark(bookmarkId: String, callback: GetBookmarkCallback)

    fun saveBookmark(bookmark: Bookmark)

    fun deleteAllBookmarks()

    fun deleteBookmark(bookmarkId: String)
}