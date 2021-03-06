package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogImage {

    @JsonCreator
    public CatalogImage(
            @JsonProperty("name") String name,
            @JsonProperty("url") String url,
            @JsonProperty("caption") String caption) {
        this.name = name;
        this.url = url;
        this.caption = caption;
    }

    private final String name;
    private final String url;
    private final String caption;

    @Override
    public int hashCode() {
        return Objects.hash(name, url, caption);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogImage)) {
            return false;
        }
        CatalogImage catalogImage = (CatalogImage) o;
        return Objects.equals(name, catalogImage.name) &&
            Objects.equals(url, catalogImage.url) &&
            Objects.equals(caption, catalogImage.caption);
    }

    /**
     * Getter for Name.
     * The internal name of this image. Identifies this image in calls to the
     * Connect APIs.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for Url.
     * The URL of this image. Generated by Square after an image is uploaded
     * to the CreateCatalogImage endpoint.
     */
    @JsonGetter("url")
    public String getUrl() { 
        return this.url;
    }

    /**
     * Getter for Caption.
     * A caption that describes what is shown in the image. Displayed in the
     * Square Online Store.
     */
    @JsonGetter("caption")
    public String getCaption() { 
        return this.caption;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .url(getUrl())
            .caption(getCaption());
            return builder;
    }

    public static class Builder {
        private String name;
        private String url;
        private String caption;

        public Builder() { }

        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder url(String value) {
            url = value;
            return this;
        }
        public Builder caption(String value) {
            caption = value;
            return this;
        }

        public CatalogImage build() {
            return new CatalogImage(name,
                url,
                caption);
        }
    }
}
