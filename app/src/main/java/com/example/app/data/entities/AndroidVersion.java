package com.example.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 11/3/17.
 */

public class AndroidVersion implements Parcelable {

  private String version;
  private String codeName;
  private boolean selected;

  public AndroidVersion(String version, String codeName) {
    this.version = version;
    this.codeName = codeName;
  }

  public void toggleSelected() {
    selected = !selected;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getCodeName() {
    return codeName;
  }

  public void setCodeName(String codeName) {
    this.codeName = codeName;
  }

  public boolean isSelected() {
    return selected;
  }

  protected AndroidVersion(Parcel in) {
    version = in.readString();
    codeName = in.readString();
    selected = in.readByte() != 0x00;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(version);
    dest.writeString(codeName);
    dest.writeByte((byte) (selected ? 0x01 : 0x00));
  }

  @SuppressWarnings("unused")
  public static final Parcelable.Creator<AndroidVersion> CREATOR = new Parcelable.Creator<AndroidVersion>() {
    @Override
    public AndroidVersion createFromParcel(Parcel in) {
      return new AndroidVersion(in);
    }

    @Override
    public AndroidVersion[] newArray(int size) {
      return new AndroidVersion[size];
    }
  };
}
