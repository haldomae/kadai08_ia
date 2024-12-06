package com.hal_domae.kadai08_ia

import android.app.DatePickerDialog
import android.app.Dialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // 現在の年月日を取得
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // DatePickerに現在の日付を設定する
        return activity?.let {
            DatePickerDialog(
                it,
                this,
                year,
                month,
                day
            )
        }?: throw IllegalStateException("画面がありません")
    }


    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        activity?.findViewById<EditText>(R.id.select_date)?.setText(getString(R.string.formatted_date, p1, p2, p3))
    }
}