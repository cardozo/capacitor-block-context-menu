package com.santos.matheus.blockcontextmenu;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.PluginMethod;

@CapacitorPlugin(name = "BlockContextMenu")
public class BlockContextMenuPlugin extends Plugin {

    private BlockContextMenu implementation = new BlockContextMenu();

    @Override
    public void load() {
        implementation.blockContextMenu(getBridge().getWebView());  // Pass the WebView from Capacitor to the blocker.
    }

}