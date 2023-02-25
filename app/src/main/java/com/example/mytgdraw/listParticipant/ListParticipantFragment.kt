package com.example.mytgdraw.listParticipant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.mytgdraw.databinding.FragmentListParticipantBinding

private const val LIST_PARTICIPANT = "list_participant"

class ListParticipantFragment : Fragment() {
    private var listParticipant: String? = null
    private lateinit var binding: FragmentListParticipantBinding
    private lateinit var viewModel:ViewModel
    private lateinit var rvAdapter: Adapter
    private var countParticipant = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            listParticipant = it.getString(LIST_PARTICIPANT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListParticipantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModel(listParticipant?:"")
        setupRecyclerView()
        observeViewModel()
        setupBtnClickListener()
    }

    private fun observeViewModel(){
        viewModel.listParticipant.observe(viewLifecycleOwner){
            rvAdapter.submitList(it)
        }
        viewModel.countParticipant.observe(viewLifecycleOwner){
            binding.tvCountParticipant.text = "${binding.tvCountParticipant.text} $it"
        }
        viewModel.winner.observe(viewLifecycleOwner){
            binding.tvNumOfWinner.text = "${binding.tvNumOfWinner.text} ${it.id}"
            binding.tvWinner.text = "Победитель : ${it.name}"
        }
    }

    private fun setupBtnClickListener(){
        binding.btnChooseWinner.setOnClickListener {
            viewModel.chooseWinner()
        }
    }

    private fun setupRecyclerView(){
        with(binding.mainRecyclerView){
            rvAdapter = Adapter()
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(listParticipant: String) =
            ListParticipantFragment().apply {
                arguments = Bundle().apply {
                    putString(LIST_PARTICIPANT, listParticipant)
                }
            }
    }
}