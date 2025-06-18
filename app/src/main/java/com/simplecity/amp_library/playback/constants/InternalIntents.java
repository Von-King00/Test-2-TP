package com.simplecity.amp_library.playback.constants;

public final class InternalIntentsConstants {
    private InternalIntentsConstants() {}

    public static final String INTERNAL_INTENT_PREFIX = "com.simplecity.shuttle";
    public static final String PLAY_STATE_CHANGED = INTERNAL_INTENT_PREFIX + ".playstatechanged";
    public static final String POSITION_CHANGED = INTERNAL_INTENT_PREFIX + ".positionchanged";
    public static final String TRACK_ENDING = INTERNAL_INTENT_PREFIX + ".trackending";
    public static final String META_CHANGED = INTERNAL_INTENT_PREFIX + ".metachanged";
    public static final String QUEUE_CHANGED = INTERNAL_INTENT_PREFIX + ".queuechanged";
    public static final String SHUFFLE_CHANGED = INTERNAL_INTENT_PREFIX + ".shufflechanged";
    public static final String REPEAT_CHANGED = INTERNAL_INTENT_PREFIX + ".repeatchanged";
    public static final String FAVORITE_CHANGED = INTERNAL_INTENT_PREFIX + ".favoritechanged";
    public static final String SERVICE_CONNECTED = INTERNAL_INTENT_PREFIX + ".serviceconnected";
}
