package com.gmb.webviewteste.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.gmb.webviewteste.R
import com.gmb.webviewteste.databinding.FragmentVideoBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class VideoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView: WebView = binding.wbWebview
        webView.webChromeClient = WebChromeClient()

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
        }

        // Configurar as configurações do WebView, se necessário
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Carregar uma URL de exemplo
        webView.loadUrl("https://www.youtube.com/watch?v=2X_2IdybTV0")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}