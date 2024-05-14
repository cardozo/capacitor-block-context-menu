package com.santos.matheus.blockcontextmenu;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "BlockContextMenu")
public class BlockContextMenuPlugin extends Plugin {

    private BlockContextMenu implementation = new BlockContextMenu();

    @PluginMethod
    public void load() {
        implementation.setupWebView(getBridge().getWebView());
    }
}
