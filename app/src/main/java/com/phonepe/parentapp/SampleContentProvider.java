package com.phonepe.parentapp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;

public class SampleContentProvider extends ContentProvider {

    private static final String TAG = "SampleContentProvider";

    private static final String AUTHORITY = "com.phonepe.parentapp.key";
    private static final String PATH = "external";
    private static final int KEY = 1;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITY, PATH, KEY);
    }


    public SampleContentProvider() {
    }

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate: ");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.d(TAG, "query: Uri: "+uri.toString()+" projection: "+projection+" selection: "+selection+" selectionArgs: "+selectionArgs+" sortOrder: "+sortOrder);
        switch(uriMatcher.match(uri)) {
            case KEY:
                MatrixCursor cursor = new MatrixCursor(new String[]{"TEXT"}, 1);
                cursor.addRow(new String[]{DataStorage.getText()});
                return cursor;
            default:
                throw new UnsupportedOperationException(uri.toString() + " for query action is not supported");
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        Log.d(TAG, "getType: Uri: "+uri);
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
