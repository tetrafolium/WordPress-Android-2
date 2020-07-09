package org.wordpress.android.ui.media;

public enum MediaBrowserType {
    BROWSER, // browse & manage media
    EDITOR_PICKER, // select multiple images or videos to insert into a post
    AZTEC_EDITOR_PICKER, // select multiple images or videos to insert into a post, hide source bar in portrait
    FEATURED_IMAGE_PICKER, // select a single image as a featured image
    GRAVATAR_IMAGE_PICKER, // select a single image as a gravatar
    SITE_ICON_PICKER, // select a single image as a site icon
    GUTENBERG_IMAGE_PICKER, // select image from Gutenberg editor
    GUTENBERG_VIDEO_PICKER; // select video from Gutenberg editor

    public boolean isPicker() {
        return this != BROWSER;
    }

    public boolean isBrowser() {
        return this == BROWSER;
    }

    public boolean isSingleImagePicker() {
        return this == FEATURED_IMAGE_PICKER || this == GRAVATAR_IMAGE_PICKER || this == SITE_ICON_PICKER;
    }

    public boolean canMultiselect() {
        return this == EDITOR_PICKER
        || this == AZTEC_EDITOR_PICKER
        || this == GUTENBERG_IMAGE_PICKER
        || this == GUTENBERG_VIDEO_PICKER;
    }

    public boolean canFilter() {
        return this == BROWSER;
    }

    public boolean canOnlyDoInitialFilter() {
        return this == GUTENBERG_IMAGE_PICKER || this == GUTENBERG_VIDEO_PICKER;
    }
}
