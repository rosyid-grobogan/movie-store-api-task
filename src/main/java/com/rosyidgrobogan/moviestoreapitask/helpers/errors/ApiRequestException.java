package com.rosyidgrobogan.moviestoreapitask.helpers.errors;

public class ApiRequestException
    extends RuntimeException
{
    public ApiRequestException(String message)
    {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
