package com.simplecity.amp_library.model;

import android.net.Uri;
import java.util.Arrays;

public class Query {

    private Uri uri;
    private String[] projection;
    private String selection;
    private String[] args;
    private String sort;

    Query(Builder builder) {
        uri = builder.uri;
        projection = builder.projection;
        selection = builder.selection;
        args = builder.args;
        sort = builder.sort;
    }

    public static final class Builder {
        Uri uri;
        String[] projection;
        String selection;
        String[] args;
        String sort;

        public Builder() {
        }

        public Builder uri(Uri val) {
            uri = val;
            return this;
        }

        public Builder projection(String[] val) {
            projection = val;
            return this;
        }

        public Builder selection(String val) {
            selection = val;
            return this;
        }

        public Builder args(String[] val) {
            args = val;
            return this;
        }

        public Builder sort(String val) {
            sort = val;
            return this;
        }

        public Query build() {
            return new Query(this);
        }
    }

    public Uri getUri() { return uri; }
    public String[] getProjection() { return projection; }
    public String getSelection() { return selection; }
    public String[] getArgs() { return args; }
    public String getSort() { return sort; }

    @Override
    public String toString() {
        return "Query{" +
                "\nuri=" + uri +
                "\nPROJECTION=" + Arrays.toString(projection) +
                "\nselection='" + selection + '\'' +
                "\nargs=" + Arrays.toString(args) +
                "\nsort='" + sort + '\'' +
                '}';
    }
}