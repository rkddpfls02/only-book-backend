package org.myongjithon.onlybook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.myongjithon.onlybook.exception.CustomException;

@AllArgsConstructor
@Getter
public class ErrorResponseDto {
    private final String errorCode;
    private final String message;
    private final String detail;

    public static ErrorResponseDto res(final CustomException customException){
        String errorCode = customException.getErrorCode().getCode();
        String message = customException.getErrorCode().getMessage();
        String detail = customException.getDetail();
        return new ErrorResponseDto(errorCode,message,detail);
    }

    public static ErrorResponseDto res(final String errorCode, final Exception e){
        return new ErrorResponseDto(errorCode, e.getMessage(), null);
    }

}
