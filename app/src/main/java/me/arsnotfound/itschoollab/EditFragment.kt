package me.arsnotfound.itschoollab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import me.arsnotfound.itschoollab.databinding.FragmentEditBinding

class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)

        binding.returnBtn.setOnClickListener {
            viewModel.changeText(binding.valueEt.text.toString())
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, TextFragment::class.java, null)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       viewModel.textValue.observe(viewLifecycleOwner) { value ->
           binding.valueEt.setText(value, TextView.BufferType.EDITABLE)
       }
    }
}