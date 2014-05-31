package me.CodeingBoy.RemoveSimpleStatusbar;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedBridge;
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
	    	        	if (SimpBar != null){
	    	        		LayoutParams lp = (LayoutParams) SimpBar.getLayoutParams();
	    	        		lp.height = 0;
	    	        		SimpBar.requestLayout();
	    	        	}

	    	        }
	    	    });
	    }
		
	}





