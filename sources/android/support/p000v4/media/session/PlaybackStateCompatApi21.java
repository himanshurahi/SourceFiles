package android.support.p000v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.CustomAction.Builder;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.media.session.PlaybackStateCompatApi21 */
class PlaybackStateCompatApi21 {

    /* renamed from: android.support.v4.media.session.PlaybackStateCompatApi21$CustomAction */
    static final class CustomAction {
        public static String getAction(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getAction();
        }

        public static CharSequence getName(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getName();
        }

        public static int getIcon(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getIcon();
        }

        public static Bundle getExtras(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getExtras();
        }

        public static Object newInstance(String str, CharSequence charSequence, int i, Bundle bundle) {
            Builder builder = new Builder(str, charSequence, i);
            builder.setExtras(bundle);
            return builder.build();
        }

        private CustomAction() {
        }
    }

    public static int getState(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static long getPosition(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long getBufferedPosition(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float getPlaybackSpeed(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long getActions(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence getErrorMessage(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long getLastPositionUpdateTime(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static List<Object> getCustomActions(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static long getActiveQueueItemId(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    public static Object newInstance(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<Object> list, long j5) {
        PlaybackState.Builder builder = new PlaybackState.Builder();
        builder.setState(i, j, f, j4);
        long j6 = j2;
        builder.setBufferedPosition(j2);
        long j7 = j3;
        builder.setActions(j3);
        builder.setErrorMessage(charSequence);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            builder.addCustomAction((android.media.session.PlaybackState.CustomAction) it.next());
        }
        builder.setActiveQueueItemId(j5);
        return builder.build();
    }

    private PlaybackStateCompatApi21() {
    }
}
