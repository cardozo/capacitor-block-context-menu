package com.santos.matheus.blockcontextmenu;

import android.util.Log;
import android.webkit.WebView;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

public class BlockContextMenu {

    public void blockContextMenu(WebView webView) {
        webView.setOnLongClickListener(view -> true);  // Ignore long press to block context menu.
        Log.i("BlockContextMenu", "Context menu is blocked.");
    }

}
