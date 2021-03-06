/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jrooms.bookmark_kotlin.deletebookmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.jrooms.bookmark_kotlin.R
import com.jrooms.bookmark_kotlin.util.obtainViewModel
import com.jrooms.bookmark_kotlin.util.replaceFragmentInActivity
import com.jrooms.bookmark_kotlin.util.setupActionBar

class DeleteBookmarkActivity : AppCompatActivity() {

  private lateinit var viewModel: DeleteBookmarkViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    overridePendingTransition(R.anim.fadein, R.anim.fadeout)
    setContentView(R.layout.delete_bookmark_act)

    setupActionBar(R.id.toolbar) {
      setDisplayHomeAsUpEnabled(true)
      setTitle(R.string.delete_bookmark)
    }

    setupFragment()

    viewModel = obtainViewModel()
  }

  fun obtainViewModel(): DeleteBookmarkViewModel =
    obtainViewModel(DeleteBookmarkViewModel::class.java, this)


  private fun setupFragment() {
    supportFragmentManager.findFragmentById(R.id.content_frame)
      ?: replaceFragmentInActivity(DeleteBookmarkFragment.newInstance(), R.id.content_frame)
  }

  override fun onOptionsItemSelected(item: MenuItem) =
    when (item.itemId) {
      android.R.id.home -> {
        finish()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        true
      }
      else -> super.onOptionsItemSelected(item)
    }

  override fun onBackPressed() {
    super.onBackPressed()

    finish()
    overridePendingTransition(R.anim.fadein, R.anim.fadeout)
  }

  companion object {

    const val REQUEST_CODE = 1
  }
}