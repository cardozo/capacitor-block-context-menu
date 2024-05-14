package com.santos.matheus.blockcontextmenu;

import android.view.ContextMenu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BlockContextMenu {

    public void setupWebView(WebView webView) {
        webView.setWebViewClient(new WebViewClient() {
            // Mantém o comportamento padrão, permitindo seleção de texto
        });

        webView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                // Bloqueia efetivamente o menu de contexto, não adicionando itens
                menu.clear();  // Assegura que nenhum item de menu seja mostrado
            }
        });
    }
}
