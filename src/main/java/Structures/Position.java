package Structures;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.NamedArg;

public class Position<X,Y> implements Serializable {

    /**
     * Creates a new position
     * @param x The x coordinate for this position
     * @param y The y coordinate to use for this position
     */
    public Position(@NamedArg("horizontal") X x, @NamedArg("vertical") Y y) {
        this.horizontal = x;
        this.vertical = y;
        List list = new ArrayList();
    }

    /**
     * X coordinate of this <code>Position</code>.
     */
    private X horizontal;

    /**
     * Gets the x coordinate for this position.
     * @return x coordinate for this position
     */
    public X getHorizontal() { return horizontal; }

    /**
     * Y coordinate of this this <code>Position</code>.
     */
    private Y vertical;

    /**
     * Gets the y coordinate for this position.
     * @return y coordinate for this position
     */
    public Y getVertical() { return vertical; }

    /**
     * <p><code>String</code> representation of this
     * <code>Position</code>.</p>
     *
     * <p>The default name/value delimiter '=' is always used.</p>
     *
     *  @return <code>String</code> representation of this <code>Position</code>
     */
    @Override
    public String toString() {
        return horizontal + "," + vertical;
    }
    

    /**
     * <p>Test this <code>Position</code> for equality with another
     * <code>Object</code>.</p>
     *
     * <p>If the <code>Object</code> to be tested is not a
     * <code>Position</code> or is <code>null</code>, then this method
     * returns <code>false</code>.</p>
     *
     * <p>Two <code>Position</code>s are considered equal if and only if
     * both the names and values are equal.</p>
     *
     * @param o the <code>Object</code> to test for
     * equality with this <code>Position</code>
     * @return <code>true</code> if the given <code>Object</code> is
     * equal to this <code>Position</code> else <code>false</code>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Position) {
            Position position = (Position) o;
            if (horizontal != null ? !horizontal.equals(position.horizontal) : position.horizontal != null) return false;
            if (vertical != null ? !vertical.equals(position.vertical) : position.vertical != null) return false;
            return true;
        }
        return false;
    }

}
