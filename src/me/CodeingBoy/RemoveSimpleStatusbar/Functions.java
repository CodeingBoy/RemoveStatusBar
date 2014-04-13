package me.CodeingBoy.RemoveSimpleStatusbar;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;

public class Functions implements IXposedHookInitPackageResources {

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





