package com.brentvatne.exoplayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ReactExoplayerResourcesManager {

    interface OnFreeInstanceListener {
        void onFreeInstance();
    }
    private static Set<OnFreeInstanceListener> sOnFreeInstanceListeners = new HashSet<>();
    public static void freeResources() {
        for(OnFreeInstanceListener listener : new ArrayList<>(sOnFreeInstanceListeners)) {
            try {
                listener.onFreeInstance();
            }
            catch (Exception e) {
                //
            }
        }
        sOnFreeInstanceListeners.clear();
    }

    static void reg(OnFreeInstanceListener listener) {
        sOnFreeInstanceListeners.add(listener);
    }
}
