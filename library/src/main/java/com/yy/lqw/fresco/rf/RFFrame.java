package com.yy.lqw.fresco.rf;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;

/**
 * Created by lunqingwen on 2016/11/10.
 */

class RFFrame implements AnimatedImageFrame {
    private final int mFrameNumber;
    private final RFDescriptor mDescriptor;
    private final Canvas mCanvas = new Canvas();

    public RFFrame(int frameNumber, RFDescriptor descriptor) {
        mFrameNumber = frameNumber;
        mDescriptor = descriptor;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void renderFrame(int width, int height, Bitmap bitmap) {
        mCanvas.setBitmap(bitmap);
        final String key = mDescriptor.frames.get(mFrameNumber);
        final Bitmap bmp = mDescriptor.cache.get(key);
        mCanvas.drawBitmap(bmp, 0, 0, null);
    }

    @Override
    public int getDurationMs() {
        return 1000 / mDescriptor.fps;
    }

    @Override
    public int getWidth() {
        return mDescriptor.getWidth();
    }

    @Override
    public int getHeight() {
        return mDescriptor.getHeight();
    }

    @Override
    public int getXOffset() {
        return 0;
    }

    @Override
    public int getYOffset() {
        return 0;
    }
}
