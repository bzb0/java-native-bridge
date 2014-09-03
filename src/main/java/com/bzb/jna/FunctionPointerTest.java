package com.bzb.jna;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public class FunctionPointerTest {

  public interface User32 extends StdCallLibrary {

    User32 INSTANCE = (User32) Native.loadLibrary("User32", User32.class);

    boolean EnumWindows(WNDENUMPROC lpEnumFunc, Pointer arg);
  }

  public interface WNDENUMPROC extends StdCallCallback {

    /**
     * Returns <code>true</code> if the enumeration can be continued, <code>false</code> otherwise.
     */
    boolean callback(Pointer hWnd, Pointer arg);
  }

  public static void main(String[] args) {
    User32 user32 = User32.INSTANCE;
    user32.EnumWindows(new WNDENUMPROC() {
      private int count;

      @Override
      public boolean callback(Pointer hWnd, Pointer userData) {
        System.out.println("Window: " + hWnd + ", totalCount: " + (++count));
        return true;
      }
    }, null);
  }
}
