package com.santos.matheus.blockcontextmenu;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BlockContextMenu {
    public void setupWebView(WebView webView) {
        webView.setWebViewClient(new WebViewClient() {
            // Manter o comportamento padrão, que permite seleção de texto
        });

        webView.setOnCreateContextMenuListener((menu, v, menuInfo) -> {
            // Bloquear o menu de contexto, não faça nada aqui
        });
    }
}
