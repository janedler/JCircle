package com.janedler;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;


/**
 * dip 与像素的相互转换
 */
public class UnitUtil {


    public static int dip2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static float px2dip(Context context, int pxvalue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return pxvalue/scale;
    }

}
