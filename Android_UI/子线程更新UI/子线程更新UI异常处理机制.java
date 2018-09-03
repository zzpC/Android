//代码出自 Android 7.0

//ViewRootImpl.java
//不做特殊处理,直接在子线程更新UI会有什么异常?
//抛出线程错误异常,来自ViewRootImpl的checkThread
void checkThread() {
    if (mThread != Thread.currentThread()) {
        throw new CalledFromWrongThreadException(
                "Only the original thread that created a view hierarchy can touch its views.");
    }
}

//方法中的mThread出处,可得出核心问题,子线程需要有自己的ViewRootImpl
public ViewRootImpl(Context context, Display display) {
    mContext = context;
    mWindowSession = WindowManagerGlobal.getWindowSession();
    mDisplay = display;
    mBasePackageName = context.getBasePackageName();
    mThread = Thread.currentThread();
    mLocation = new WindowLeaked(null);
    mLocation.fillInStackTrace();
    mWidth = -1;
    mHeight = -1;
    mDirty = new Rect();
    mTempRect = new Rect();
    mVisRect = new Rect();
    mWinFrame = new Rect();
    mWindow = new W(this);
    mTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
    mViewVisibility = View.GONE;
    mTransparentRegion = new Region();
    mPreviousTransparentRegion = new Region();
    mFirst = true; // true for the first time the view is added
    mAdded = false;
    mAttachInfo = new View.AttachInfo(mWindowSession, mWindow, display, this, mHandler, this,
            context);
    mAccessibilityManager = AccessibilityManager.getInstance(context);
    mAccessibilityManager.addAccessibilityStateChangeListener(
            mAccessibilityInteractionConnectionManager, mHandler);
    mHighContrastTextManager = new HighContrastTextManager();
    mAccessibilityManager.addHighTextContrastStateChangeListener(
            mHighContrastTextManager, mHandler);
    mViewConfiguration = ViewConfiguration.get(context);
    mDensity = context.getResources().getDisplayMetrics().densityDpi;
    mNoncompatDensity = context.getResources().getDisplayMetrics().noncompatDensityDpi;
    mFallbackEventHandler = new PhoneFallbackEventHandler(context);
    mChoreographer = Choreographer.getInstance();
    mDisplayManager = (DisplayManager)context.getSystemService(Context.DISPLAY_SERVICE);

    if (!sCompatibilityDone) {
        sAlwaysAssignFocus = true;

        sCompatibilityDone = true;
    }

    loadSystemProperties();
}

//以下重写方法在抛出异常时被调用
@Override
    public void invalidateChild(View child, Rect dirty) {
        invalidateChildInParent(null, dirty);
    }

    @Override
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        checkThread();
        if (DEBUG_DRAW) Log.v(mTag, "Invalidate child: " + dirty);

        if (dirty == null) {
            invalidate();
            return null;
        } else if (dirty.isEmpty() && !mIsAnimating) {
            return null;
        }

        if (mCurScrollY != 0 || mTranslator != null) {
            mTempRect.set(dirty);
            dirty = mTempRect;
            if (mCurScrollY != 0) {
                dirty.offset(0, -mCurScrollY);
            }
            if (mTranslator != null) {
                mTranslator.translateRectInAppWindowToScreen(dirty);
            }
            if (mAttachInfo.mScalingRequired) {
                dirty.inset(-1, -1);
            }
        }

        invalidateRectOnScreen(dirty);

        return null;
    }
