package com.udacity.notepad.util

import android.content.Context
import android.graphics.ColorSpace
import android.graphics.Rect
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class SpaceItemDecoration(
        context: Context,
        dimenRes: Int
) : RecyclerView.ItemDecoration() {

    private val space = context.resources.getDimensionPixelOffset(dimenRes)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)

        when (getOrientation(parent)) {
            LinearLayoutManager.VERTICAL -> if (position != 0) outRect.top = space
            LinearLayoutManager.HORIZONTAL -> if (position != 0) outRect.left = space
        }
    }

    private fun getOrientation(parent: RecyclerView): Int {
        val lm = parent.layoutManager
        return if (lm is LinearLayoutManager) {
            lm.orientation
        } else -1
    }
}