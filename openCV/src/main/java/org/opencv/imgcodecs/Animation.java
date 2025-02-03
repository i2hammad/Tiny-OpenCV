//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.imgcodecs;

import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Scalar;
import org.opencv.utils.Converters;

import java.util.ArrayList;
import java.util.List;

// C++: class Animation

/**
 * Represents an animation with multiple frames.
 * The {@code Animation} struct is designed to store and manage data for animated sequences such as those from animated formats (e.g., GIF, AVIF, APNG, WebP).
 * It provides support for looping, background color settings, frame timing, and frame storage.
 */
public class Animation {

    protected final long nativeObj;

    protected Animation(long addr) {
        nativeObj = addr;
    }

    // internal usage only
    public static Animation __fromPtr__(long addr) {
        return new Animation(addr);
    }

    // C++: int Animation::loop_count
    private static native int get_loop_count_0(long nativeObj);

    //
    // C++: int Animation::loop_count
    //

    // C++: void Animation::loop_count
    private static native void set_loop_count_0(long nativeObj, int loop_count);


    //
    // C++: void Animation::loop_count
    //

    // C++: Scalar Animation::bgcolor
    private static native double[] get_bgcolor_0(long nativeObj);


    //
    // C++: Scalar Animation::bgcolor
    //

    // C++: void Animation::bgcolor
    private static native void set_bgcolor_0(long nativeObj, double bgcolor_val0, double bgcolor_val1, double bgcolor_val2, double bgcolor_val3);


    //
    // C++: void Animation::bgcolor
    //

    // C++: vector_int Animation::durations
    private static native long get_durations_0(long nativeObj);


    //
    // C++: vector_int Animation::durations
    //

    // C++: void Animation::durations
    private static native void set_durations_0(long nativeObj, long durations_mat_nativeObj);


    //
    // C++: void Animation::durations
    //

    // C++: vector_Mat Animation::frames
    private static native long get_frames_0(long nativeObj);


    //
    // C++: vector_Mat Animation::frames
    //

    // C++: void Animation::frames
    private static native void set_frames_0(long nativeObj, long frames_mat_nativeObj);


    //
    // C++: void Animation::frames
    //

    // native support for java finalize()
    private static native void delete(long nativeObj);

    public long getNativeObjAddr() {
        return nativeObj;
    }

    public int get_loop_count() {
        return get_loop_count_0(nativeObj);
    }

    public void set_loop_count(int loop_count) {
        set_loop_count_0(nativeObj, loop_count);
    }

    public Scalar get_bgcolor() {
        return new Scalar(get_bgcolor_0(nativeObj));
    }

    public void set_bgcolor(Scalar bgcolor) {
        set_bgcolor_0(nativeObj, bgcolor.val[0], bgcolor.val[1], bgcolor.val[2], bgcolor.val[3]);
    }

    public MatOfInt get_durations() {
        return MatOfInt.fromNativeAddr(get_durations_0(nativeObj));
    }

    public void set_durations(MatOfInt durations) {
        Mat durations_mat = durations;
        set_durations_0(nativeObj, durations_mat.nativeObj);
    }

    public List<Mat> get_frames() {
        List<Mat> retVal = new ArrayList<Mat>();
        Mat retValMat = new Mat(get_frames_0(nativeObj));
        Converters.Mat_to_vector_Mat(retValMat, retVal);
        return retVal;
    }

    public void set_frames(List<Mat> frames) {
        Mat frames_mat = Converters.vector_Mat_to_Mat(frames);
        set_frames_0(nativeObj, frames_mat.nativeObj);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }

}
