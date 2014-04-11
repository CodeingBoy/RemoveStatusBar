package com.CodeingBoy.removestatusbar;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;

public class Functions implements IXposedHookZygoteInit, IXposedHookInitPackageResources {
	 private static String MODULE_PATH = null;

	    @Override
	    public void initZygote(StartupParam startupParam) throws Throwable {
	        MODULE_PATH = startupParam.modulePath;
	    }

	    @Override
	    public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable {
	    	 if (!resparam.packageName.equals("com.android.systemui"))
	    	        return;

	    	    resparam.res.hookLayout("com.android.systemui", "layout", "status_bar_simple", new XC_LayoutInflated() {
	    	        @Override
	    	        public void handleLayoutInflated(LayoutInflatedParam liparam) throws Throwable {
	    	        	FrameLayout SimpBar = (FrameLayout)liparam.view;
	    	        	LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
	    	            SimpBar.setLayoutParams(layoutParams);
	    	        }
	    	    });
	    }
		
	}





