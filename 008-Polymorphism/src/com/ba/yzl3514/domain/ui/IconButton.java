package com.ba.yzl3514.domain.ui;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class IconButton extends Button {
    private int a = 800;
    private String icon = "none";

    public IconButton(String icon) {
        this.icon = icon;
        System.out.println("IconButton ctor, icon " + icon + ", a: " + a );
    }

    @Override
    public void render() {
        System.out.println("IconButton.render(), icon = " + icon + ", a: " + a );
    }
}
