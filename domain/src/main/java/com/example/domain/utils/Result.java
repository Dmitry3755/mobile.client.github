package com.example.domain.utils;

public abstract class Result<T> {
    public static class OK<T> extends Result<T> {
        private final T result;
        public OK(T result) {
            this.result = result;
        }
        public T getResult() {
            return result;
        }
    }
    public static class Error extends Result {
        private final String error;
        public Error(String error) {
            this.error = error;
        }
        public String getError() {
            return error;
        }
    }
    public static class Loading extends Result {
    }
}
