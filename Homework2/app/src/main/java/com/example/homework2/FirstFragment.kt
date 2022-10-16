package com.example.homework2

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.telephony.PhoneNumberUtils
import android.text.Editable
import android.text.Selection
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.text.set
import androidx.fragment.app.FragmentTransaction
import com.example.homework2.databinding.FragmentFirstBinding
import java.util.*

private var secondFragment: SecondFragment = SecondFragment()
private lateinit var binding: FragmentFirstBinding

class FirstFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)



        binding.editTextPhone.addTextChangedListener(object: PhoneNumberFormattingTextWatcher() {
            private var isFirst: Boolean = true
            private var isFormatting: Boolean = false
            private var deletingHyphen: Boolean = false
            private var hyphenStart: Int = 0
            private var deletingBackward: Boolean = false
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (isFormatting)
                    return

                val selStart = Selection.getSelectionStart(s)
                val selEnd = Selection.getSelectionEnd(s)

                if (s!!.length > 1 // Can delete another character
                    && count == 1 // Deleting only one character
                    && after == 0 // Deleting
                    && (s.get(start) == '-' || s.get(start) == ' ') // a hyphen
                    && selStart == selEnd) { // no selection
                    deletingHyphen = true;
                    hyphenStart = start;
                    // Check if the user is deleting forward or backward
                    deletingBackward = selStart == start + 1
                } else {
                    deletingHyphen = false;
                }
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                val edit: EditText = activity?.currentFocus as EditText
                if (!s.toString().startsWith("8")) {
                    edit.setText("8")
                    Selection.setSelection(edit.text, edit.text.length)
                }


                if (isFormatting)
                    return
                isFormatting= true
                if (deletingHyphen && hyphenStart > 0) {
                    if (deletingBackward) {
                        if (hyphenStart - 1 < edit.text!!.length) {
                            edit.text!!.delete(hyphenStart - 1, hyphenStart)
                        }
                    } else if (hyphenStart < edit.text!!.length) {
                        edit.text!!.delete(hyphenStart, hyphenStart + 1)
                    }
                }
                toFormat(edit, s)
                isFormatting = false

                binding.editText.isEnabled = binding.editTextPhone.length() == 16
            }
        })
        binding.editText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.button.isEnabled = binding.editText.text.toString().trim().length > 5
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            val ft: FragmentTransaction? = fragmentManager?.beginTransaction()
            ft?.replace(R.id.fragmentContainerView, secondFragment)?.addToBackStack(null)
            ft?.commit()
        }
    }

    private fun toFormat(edit: EditText, s: Editable?)  {
        if (edit.text!!.length == 2) {
            var tmp : StringBuilder = StringBuilder()
            tmp.append(s.toString())
            tmp.insert(edit.text!!.length - 1, "(")
            edit.setText(tmp.toString())
            Selection.setSelection(edit.text, edit.text.length)
        }
        if (edit.text!!.length == 6) {
            var tmp : StringBuilder = StringBuilder()
            tmp.append(s.toString())
            tmp.insert(edit.text!!.length - 1, ")-")
            edit.setText(tmp.toString())
            Selection.setSelection(edit.text, edit.text.length)
        }
        if (edit.text!!.length == 11) {
            var tmp : StringBuilder = StringBuilder()
            tmp.append(s.toString())
            tmp.insert(edit.text!!.length - 1, "-")
            edit.setText(tmp.toString())
            Selection.setSelection(edit.text, edit.text.length)
        }
        if (edit.text!!.length == 14) {
            var tmp : StringBuilder = StringBuilder()
            tmp.append(s.toString())
            tmp.insert(edit.text!!.length - 1, "-")
            edit.setText(tmp.toString())
            Selection.setSelection(edit.text, edit.text.length)
        }
    }


}