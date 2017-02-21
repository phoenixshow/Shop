package com.phoenix.frescodemo;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.util.Log;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.image_view)
    private SimpleDraweeView draweeView;

    private String img_url0 = "http://gb.cri.cn/mmsource/images/2014/08/22/38/10202051462353342906.jpg";
    private String img_url1 = "http://attimg.dospy.com/img/day_101024/20101024_65c4c0e9b6404e1f4b8fHlZqY0hxz3qH.jpg";
    private String img_url2 = "http://attimg.dospy.com/img/day_101024/20101024_4905897f1d9a6c8e9436gxDWWH7cJ6JX.jpg";
    private String img_url3 = "https://a-ssl.duitang.com/uploads/item/201410/03/20141003200000_cJ5fv.jpeg";
    private String img_url4 = "http://7mno4h.com2.z0.glb.qiniucdn.com/3859deb07d4647cf9183f8ea3f5aa165.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x.view().inject(this);

//        Uri uri = Uri.parse(img_url0);
//        draweeView.setImageURI(uri);

//        requestImage();

        moreImages();
    }

    private void requestImage(){
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(
                Uri.parse(img_url1))
                .setProgressiveRenderingEnabled(true)
                .build();

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(draweeView.getController())
                .build();
        draweeView.setController(controller);
    }

    private void moreImages(){
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(
                    String id,
                    @Nullable ImageInfo imageInfo,
                    @Nullable Animatable anim) {
                if (imageInfo == null) {
                    return;
                }
                QualityInfo qualityInfo = imageInfo.getQualityInfo();
                FLog.d("Final image received! " +
                                "Size %d x %d",
                        "Quality level %d, good enough: %s, full quality: %s",
                        imageInfo.getWidth(),
                        imageInfo.getHeight(),
                        qualityInfo.getQuality(),
                        qualityInfo.isOfGoodEnoughQuality(),
                        qualityInfo.isOfFullQuality());
                Log.e("---------->", "Final image received! " +
                                "Size "+imageInfo.getWidth()+" x "+imageInfo.getHeight()+" "+
                        "Quality level "+qualityInfo.getQuality()+
                                ", good enough: "+qualityInfo.isOfGoodEnoughQuality()+
                                ", full quality: "+qualityInfo.isOfFullQuality());
            }

            @Override
            public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
                FLog.d("","Intermediate image received");
                Log.e("---------->","Intermediate image received");
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                FLog.e(getClass(), throwable, "Error loading %s", id);
                Log.e("---------->", "Error loading "+id);
            }
        };

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setControllerListener(controllerListener)
                .setLowResImageRequest(ImageRequest.fromUri(img_url4))
                .setImageRequest(ImageRequest.fromUri(img_url3))
                .build();
        draweeView.setController(controller);
    }
}
