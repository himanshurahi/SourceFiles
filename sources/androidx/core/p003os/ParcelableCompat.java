package androidx.core.p003os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

@Deprecated
/* renamed from: androidx.core.os.ParcelableCompat */
public final class ParcelableCompat {

    /* renamed from: androidx.core.os.ParcelableCompat$ParcelableCompatCreatorHoneycombMR2 */
    static class ParcelableCompatCreatorHoneycombMR2<T> implements ClassLoaderCreator<T> {
        private final ParcelableCompatCreatorCallbacks<T> mCallbacks;

        ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
            this.mCallbacks = parcelableCompatCreatorCallbacks;
        }

        public T createFromParcel(Parcel parcel) {
            return this.mCallbacks.createFromParcel(parcel, null);
        }

        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.mCallbacks.createFromParcel(parcel, classLoader);
        }

        public T[] newArray(int i) {
            return this.mCallbacks.newArray(i);
        }
    }

    @Deprecated
    public static <T> Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return new ParcelableCompatCreatorHoneycombMR2(parcelableCompatCreatorCallbacks);
    }

    private ParcelableCompat() {
    }
}
