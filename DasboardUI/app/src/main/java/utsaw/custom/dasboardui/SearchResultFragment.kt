package utsaw.custom.dasboardui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu

class SearchResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                // Handle item 1 click
                true
            }

            R.id.travel -> {
                // Handle item 2 click
                true
            }

            R.id.timer -> {
                // Handle item 3 click
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val root = inflater.inflate(R.layout.fragment_search_result_f_ragment, container, false)
        val imageView = root.findViewById<ImageView>(R.id.optionMenuBtn)
        imageView.setOnClickListener {
           showPopupMenu(imageView)
        }
        return root
    }
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view)
        val menu = popupMenu.menu
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.search_menu, menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Handle item 1 click
                    true
                }
                R.id.travel -> {
                    // Handle item 2 click
                    true
                }
                R.id.timer -> {
                    // Handle item 3 click
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

}