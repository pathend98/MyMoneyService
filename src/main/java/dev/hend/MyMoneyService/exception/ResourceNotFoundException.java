package dev.hend.MyMoneyService.exception;

import lombok.Getter;

@Getter
public abstract class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String identifier;

    public ResourceNotFoundException(String resourceName, String identifier) {
        this(resourceName, identifier, null, null);
    }

    public ResourceNotFoundException(String resourceName, String identifier, String message) {
        this(resourceName, identifier, message, null);
    }

    public ResourceNotFoundException(String resourceName, String identifier, Throwable cause) {
        this(resourceName, identifier, null, cause);
    }

    public ResourceNotFoundException(String resourceName, String identifier, String message, Throwable cause) {
        super(message, cause);
        this.resourceName = resourceName;
        this.identifier = identifier;
    }
}
