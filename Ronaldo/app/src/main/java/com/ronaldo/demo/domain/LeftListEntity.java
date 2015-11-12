package com.ronaldo.demo.domain;

/**
 * Created by wcx on 2015/11/12.
 */
public class LeftListEntity extends BaseEntity{
    private int iconResId;
    public LeftListEntity(String id, String name, int iconResId) {
        super(id, name);
        this.iconResId = iconResId;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }
}
