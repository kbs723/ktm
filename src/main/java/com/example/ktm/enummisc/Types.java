package com.example.ktm.enummisc;

public class Types {

    public enum ResponseType {
        SUCCESS, ERROR, WARNING, INFO
    }

    public enum Errors {
        internal, generic, appuser
    }

    public enum DataSourceType {
        _PRIMARY,
        _REPLICA
    }

}
