package com.ncrash.code.jackson;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User.java
 * 
 * @author daekwon.kang
 * @since 2010. 2. 25.
 * @see
 */
public class User {
    public enum Gender { MALE, FEMALE };

    public static class Name {
      @NotNull
      @Size(min = 1, max = 2)
      private String _first;
      private String _last;

      public String getFirst() { return _first; }
      public String getLast() { return _last; }

      public void setFirst(String s) { _first = s; }
      public void setLast(String s) { _last = s; }
    }

    private Gender _gender;
    private Name _name;
    private boolean _isVerified;
    private byte[] _userImage;

    public Name getName() { return _name; }
    public boolean isVerified() { return _isVerified; }
    public Gender getGender() { return _gender; }
    public byte[] getUserImage() { return _userImage; }

    public void setName(Name n) { _name = n; }
    public void setVerified(boolean b) { _isVerified = b; }
    public void setGender(Gender g) { _gender = g; }
    public void setUserImage(byte[] b) { _userImage = b; }
}

