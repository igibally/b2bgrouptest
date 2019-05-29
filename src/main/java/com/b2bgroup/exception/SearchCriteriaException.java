package com.b2bgroup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The Search Operation failed !!")
public class SearchCriteriaException extends Exception
{

    static final long serialVersionUID = -3387516993224229948L;


    
    public SearchCriteriaException(String message)
    {
        super(message);
    }

}
