package org.parameterizedtesting;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class CircleConverter implements ArgumentConverter {
    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        String[] radius = ((String) source).split(",");
        int r = Integer.valueOf(radius[0]);
        return new Circle(r);
    }
}
