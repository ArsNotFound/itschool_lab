package me.arsnotfound.itschoollab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import me.arsnotfound.itschoollab.databinding.FragmentTextBinding

class TextFragment : Fragment() {

    private lateinit var binding: FragmentTextBinding

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTextBinding.inflate(inflater, container, false)

        binding.toClickBtn.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, ButtonFragment::class.java, null)
            }
        }

        binding.toEditBtn.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, EditFragment::class.java, null)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.textValue.observe(viewLifecycleOwner) { value ->
            binding.valueTv.text = value
        }

        viewModel.clickedValue.observe(viewLifecycleOwner) { value ->
            binding.clickTv.text = getString(R.string.clicked_times, value)
        }
    }
}