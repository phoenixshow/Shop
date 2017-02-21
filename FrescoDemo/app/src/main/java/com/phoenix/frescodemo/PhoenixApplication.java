package com.phoenix.frescodemo;

import android.app.Application;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestLoggingListener;

import org.xutils.x;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by flashing on 2016/9/19.
 */
public class PhoenixApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能

//        //基本使用的初始化方法
//        Fresco.initialize(this);

//        //渐进式JPEG图的初始化方法
//        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
//                .setProgressiveJpegConfig(new SimpleProgressiveJpegConfig())
//                .build();
//        Fresco.initialize(this, config);

        //渐进式JPEG图+启动日志的初始化方法//查看日志shell命令：adb logcat -v threadtime | grep -iE 'LoggingListener|AbstractDraweeController|BufferedDiskCache'
        Set<RequestListener> requestListeners = new HashSet<>();
        requestListeners.add(new RequestLoggingListener());
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setProgressiveJpegConfig(new SimpleProgressiveJpegConfig())
                .setRequestListeners(requestListeners)
                .build();
        Fresco.initialize(this, config);
        FLog.setMinimumLoggingLevel(FLog.VERBOSE);
    }
}
