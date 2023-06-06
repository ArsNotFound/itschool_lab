package me.arsnotfound.itschoollab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import me.arsnotfound.itschoollab.databinding.FragmentButtonBinding

class ButtonFragment : Fragment() {

    private lateinit var binding: FragmentButtonBinding

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentButtonBinding.inflate(inflater, container, false)

        binding.clickBtn.setOnClickListener {
            viewModel.updateClicked()
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, TextFragment::class.java, null)
            }
        }

        return binding.root
    }
}