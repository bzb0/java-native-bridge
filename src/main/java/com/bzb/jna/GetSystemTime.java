package com.bzb.jna;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary;
import java.util.Arrays;
import java.util.List;

public class GetSystemTime {

  /**
   * kernel32.dll uses the __stdcall calling convention and therefore we extend StdCallLibrary
   */
  public interface Kernel32 extends StdCallLibrary {

    Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);

    void GetSystemTime(SystemTime result);
  }

  // structures
  public static class SystemTime extends Structure {

    public short wYear;
    public short wMonth;
    public short wDayOfWeek;
    public short wDay;
    public short wHour;
    public short wMinute;
    public short wSecond;
    public short wMilliseconds;

    protected List<String> getFieldOrder() {
      return Arrays.asList("wYear", "wMonth", "wDayOfWeek", "wDay", "wHour", "wMinute", "wSecond", "wMilliseconds");
    }
  }

  public static void main(String[] args) {
    SystemTime time = new SystemTime();
    Kernel32.INSTANCE.GetSystemTime(time);
    System.out.println("The current time is: " + time.wHour + ":" + time.wMinute + ":" + time.wSecond + " "
        + time.wDay + "/" + time.wMonth + "/" + time.wYear);
  }
}
