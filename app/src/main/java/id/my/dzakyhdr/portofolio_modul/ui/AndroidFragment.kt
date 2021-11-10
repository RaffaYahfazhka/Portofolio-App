package id.my.dzakyhdr.portofolio_modul.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import id.my.dzakyhdr.portofolio_modul.R
import id.my.dzakyhdr.portofolio_modul.adapter.RVAndroidAdapter
import id.my.dzakyhdr.portofolio_modul.data.PortofolioData
import id.my.dzakyhdr.portofolio_modul.databinding.FragmentAndroidBinding

private const val PORTOFOLIO_LINK = "https://www.dzakyhdr.my.id/"

class AndroidFragment : Fragment() {

    private var _binding: FragmentAndroidBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAndroidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val androidAdapter = RVAndroidAdapter()
        androidAdapter.setData(PortofolioData.listAppAndroid)

        androidAdapter.onItemClicked = { selectedData ->
            CustomTabsIntent.Builder().build()
                .launchUrl(requireContext(), Uri.parse(selectedData.link))
        }

        with(binding.rvAndroid) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = androidAdapter
        }

        binding.btnAndroid.text = getString(
            R.string.app_android_btn,
            PortofolioData.listAppAndroid.size.toString()
        )

        binding.txtDokumentasi.setOnClickListener {
            CustomTabsIntent.Builder().build()
                .launchUrl(requireContext(), Uri.parse(PORTOFOLIO_LINK))
        }
    }


}