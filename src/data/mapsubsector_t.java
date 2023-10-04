package data;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import w.CacheableDoomObject;

/** SubSector, as generated by BSP. */
public class mapsubsector_t implements CacheableDoomObject {

    public mapsubsector_t() {

    }

    public char numsegs;
    /** Index of first one, segs are stored sequentially. */
    public char firstseg;

    @Override
    public void unpack(ByteBuffer buf)
            throws IOException {
        buf.order(ByteOrder.LITTLE_ENDIAN);
        this.numsegs = buf.getChar();
        this.firstseg = buf.getChar();

    }

    public static int sizeOf() {
        return 4;
    }
}
