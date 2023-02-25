package com.example.mytgdraw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mytgdraw.databinding.FragmentInputListBinding
import com.example.mytgdraw.listParticipant.ListParticipantFragment

class InputListFragment : Fragment() {

    private lateinit var binding: FragmentInputListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInputListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etInputList.setOnClickListener {
            binding.etInputList.setText("")
        }
        binding.btnGoToListParticipant.setOnClickListener {
            val list = binding.etInputList.text.toString()
            val fragment = ListParticipantFragment.newInstance(list)
            parentFragmentManager.apply{
                beginTransaction()
                    .replace(R.id.mainContaynerView,fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}